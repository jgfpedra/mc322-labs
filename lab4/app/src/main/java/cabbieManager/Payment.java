package cabbieManager;
/**
 * Interface que define as operações relacionadas a pagamentos no sistema de gerenciamento de táxis.
 *
 * Esta interface declara métodos que devem ser implementados por qualquer classe que represente
 * um método de pagamento. Os métodos incluem o cálculo do valor do pagamento e o processamento do mesmo.
 *
 * Métodos principais:
 * - {@link #calculateValue()} : Calcula e retorna o valor do pagamento.
 * - {@link #processPayment()} : Processa o pagamento com base nas informações fornecidas.
 */
public interface Payment {
    /**
     * Calcula e retorna o valor do pagamento.
     *
     * @return o valor do pagamento calculado.
     */
    public float calculateValue();
        /**
     * Processa o pagamento.
     *
     * Este método deve inclui a lógica necessária para realizar o pagamento, com a
     * atualização do status da transação.
     */
    public void processPayment();
}
