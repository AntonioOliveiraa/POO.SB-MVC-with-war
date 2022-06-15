/**
 * ENUM que tratará do sexc do usuario
 * @ author Walysson  Cruz
 * @ see
 * @ since 1.0
 * @ Criada em 01/06/2022 ás 15:26
 *
 */
package br.com.devmedia.curso.domain;

public enum TipoSexo {
    FEMININO('F'), MASCULINO('M');//descrição do tipo char

    private char desc;

    TipoSexo(char desc) {
        this.desc = desc;
    }

    public char getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
