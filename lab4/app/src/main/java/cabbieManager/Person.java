package cabbieManager;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Classe abstrata que representa uma pessoa no sistema de gerenciamento de táxis.
 *
 * Esta classe serve como base para outras classes que representam tipos específicos de pessoas,
 * como passageiros e motoristas (cabbies). Contém atributos comuns, como nome, email e telefone,
 * e declara métodos que devem ser implementados pelas subclasses.
 *
 * Atributos:
 * - name: O nome da pessoa.
 * - email: O email da pessoa.
 * - phone: O telefone da pessoa.
 *
 * Métodos a serem implementados:
 * - {@link #register()} : Registra a pessoa com informações específicas.
 * - {@link #update(String, String)} : Atualiza um campo específico da pessoa.
 * - {@link #equals(Object)} : Compara esta pessoa com outra para verificar se são iguais.
 */
@XmlSeeAlso({Passenger.class, Cabbie.class})
public abstract class Person{
    protected String name;
    protected String email;
    protected String phone;
    /**
     * Registra a pessoa, atribuindo informações necessárias.
     * Este método deve ser implementado pelas subclasses para fornecer lógica de registro específica.
     */
    public abstract void register();
    /**
     * Atualiza um campo da pessoa.
     *
     * @param field O campo a ser atualizado.
     * @param newValue O novo valor para o campo.
     */
    public abstract void update(String field, String newValue);
    /**
     * Compara esta pessoa com outro objeto para verificar se são iguais.
     *
     * @param o O objeto a ser comparado com esta pessoa.
     * @return true se o objeto for igual a esta pessoa, caso contrário, false.
     */
    public abstract boolean equals(Object o);
}