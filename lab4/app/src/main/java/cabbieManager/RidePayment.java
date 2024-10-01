package cabbieManager;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateTimeAdapter;

/**
 * Classe que representa um pagamento de corrida.
 *
 * Esta classe implementa a interface {@link Payment} e gerencia as informações
 * relacionadas ao pagamento de uma corrida, incluindo o cálculo do valor total
 * com base na distância percorrida e na forma de pagamento escolhida.
 *
 * <p>A classe contém:</p>
 * <ul>
 *     <li>Um ID único para o pagamento.</li>
 *     <li>O ID da corrida associada ao pagamento.</li>
 *     <li>O horário de início da corrida.</li>
 *     <li>A distância percorrida durante a corrida.</li>
 *     <li>O valor total a ser pago.</li>
 *     <li>A forma de pagamento utilizada.</li>
 * </ul>
 *
 * <p>Os métodos principais incluem:</p>
 * <ul>
 *     <li>{@link #calculateValue()} - Calcula o valor total do pagamento com base na distância e na forma de pagamento.</li>
 *     <li>{@link #processPayment()} - Processa o pagamento e imprime o valor da corrida.</li>
 * </ul>
 */
@XmlRootElement(name = "ridePayment")
public class RidePayment implements Payment{
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;
    public RidePayment(){
    }
    public RidePayment(String rideId, LocalDateTime rideStartTime, float rideDistance ,String paymentMethod) {
        this.paymentId = UUID.randomUUID().toString();
        this.rideId = rideId;
        this.rideStartTime = rideStartTime;
        this.rideDistance = rideDistance;
        this.paymentMethod = this.selectPaymentMethod(paymentMethod);
        System.out.println("Forma de pagamento selecionada: " + paymentMethod);
        this.amount = this.calculateValue();
    }
    /**
     * Selects a PaymentOption from a given string.
     * @param paymentMethod the name of the payment method
     * @return the selected PaymentOption
     * @throws IllegalArgumentException if paymentMethod is not a valid PaymentOption
     */
    private PaymentOption selectPaymentMethod(String paymentMethod) {
        return PaymentOption.valueOfName(paymentMethod);
    }
    /**
     * Calculates the value of the ride.
     *
     * The value is calculated using the price table
     *
     * @return the calculated value of the ride.
     */
    public float calculateValue() {
        final float[] PRECO_INICIAL_DIURNO = {5.00f, 4.00f, 3.50f, 3.00f, 2.50f};
        final float[] PRECO_POR_KM_DIURNO = {2.00f, 2.50f, 3.00f, 4.00f, 3.50f};
        final float[] PRECO_INICIAL_NOTURNO = {6.00f, 5.00f, 4.50f, 4.00f, 3.50f};
        final float[] PRECO_POR_KM_NOTURNO = {2.50f, 3.00f, 3.50f, 4.50f, 4.0f};
        final float DISTANCIAS_LIMITE[] = {5, 10, 15, 20, 25};
        // identifies the distance range
        int faixa = -1;
        for (int i = 0; i < DISTANCIAS_LIMITE.length; i++) {
            if (this.rideDistance <= DISTANCIAS_LIMITE[i]) {
                faixa = i;
                break;
            }
        }
        // stabilish the initial and per km price
        float precoInicial = isHorarioNoturno() ? PRECO_INICIAL_NOTURNO[faixa] : PRECO_INICIAL_DIURNO[faixa];
        float precoPorKm = isHorarioNoturno() ? PRECO_POR_KM_NOTURNO[faixa] : PRECO_POR_KM_DIURNO[faixa];
        // calculates the total amount considering the payment method fee
        float _amount = this.paymentMethod.calculatePaymentFee(precoInicial + (this.rideDistance * precoPorKm));
        this.amount = Math.round(_amount * 100) / 100.0f;
        return this.amount;
    }
    private boolean isHorarioNoturno() {
        return this.rideStartTime.toLocalTime().isBefore(LocalTime.of(6, 0)) || this.rideStartTime.toLocalTime().isAfter(LocalTime.of(18, 0));
    }
    /**
     * Processa o pagamento da corrida.
    */
    public void processPayment() {
        System.out.println("Valor da corrida definido: " + this.amount);
    }
    /**
     * Obtém o ID do pagamento.
     *
     * @return o ID do pagamento (uma String)
     */
    @XmlElement
    public String getPaymentId() {
        return paymentId;
    }
    /**
     * Define o ID do pagamento.
     *
     * @param paymentId O novo ID do pagamento.
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    /**
     * Obtém o ID da corrida associada ao pagamento.
     *
     * @return o ID da corrida (uma String)
     */
    @XmlElement
    public String getRideId() {
        return rideId;
    }
    /**
     * Define o ID da corrida associada ao pagamento.
     *
     * @param rideId O novo ID da corrida.
     */
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }
    /**
     * Obtém o horário de início da corrida.
     *
     * @return o horário de início da corrida (um LocalDateTime)
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }
    /**
     * Define o horário de início da corrida.
     *
     * @param rideStartTime O novo horário de início da corrida.
     */
    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }
    /**
     * Obtém a distância da corrida.
     *
     * @return a distância da corrida (um float)
     */
    @XmlElement
    public float getRideDistance() {
        return rideDistance;
    }
    /**
     * Define a distância da corrida.
     *
     * @param rideDistance A nova distância da corrida.
     */
    public void setRideDistance(float rideDistance) {
        this.rideDistance = rideDistance;
    }
    /**
     * Obtém o valor total a ser pago pela corrida.
     *
     * @return o valor total (um float)
     */
    @XmlElement
    public float getAmount() {
        return amount;
    }
    /**
     * Define o valor total a ser pago pela corrida.
     *
     * @param amount O novo valor a ser pago.
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }
    /**
     * Obtém a forma de pagamento utilizada.
     *
     * @return a forma de pagamento (um objeto PaymentOption)
     */
    @XmlElement
    public PaymentOption getPaymentMethod() {
        return paymentMethod;
    }
    /**
     * Define a forma de pagamento utilizada.
     *
     * @param paymentMethod A nova forma de pagamento.
     */
    public void setPaymentMethod(PaymentOption paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
