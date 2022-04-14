/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Pc_Estiven
 */
public class Medicamento {

    private int medicamentoCodigoInsumo;
    private int medicamentoPrincipioActivoFK;
    private int medicamentoFormaFarmaceuticaFK;
    private int medicamentoConcentracionFK;
    private int medicamentoUnidadMedidaFK;

    public Medicamento() {
    }

    public Medicamento(int medicamentoCodigoInsumo, int medicamentoPrincipioActivoFK, int medicamentoFormaFarmaceuticaFK, int medicamentoConcentracionFK, int medicamentoUnidadMedidaFK) {
        this.medicamentoCodigoInsumo = medicamentoCodigoInsumo;
        this.medicamentoPrincipioActivoFK = medicamentoPrincipioActivoFK;
        this.medicamentoFormaFarmaceuticaFK = medicamentoFormaFarmaceuticaFK;
        this.medicamentoConcentracionFK = medicamentoConcentracionFK;
        this.medicamentoUnidadMedidaFK = medicamentoUnidadMedidaFK;
    }

    public int getMedicamentoCodigoInsumo() {
        return medicamentoCodigoInsumo;
    }

    public void setMedicamentoCodigoInsumo(int medicamentoCodigoInsumo) {
        this.medicamentoCodigoInsumo = medicamentoCodigoInsumo;
    }

    public int getMedicamentoPrincipioActivoFK() {
        return medicamentoPrincipioActivoFK;
    }

    public void setMedicamentoPrincipioActivoFK(int medicamentoPrincipioActivoFK) {
        this.medicamentoPrincipioActivoFK = medicamentoPrincipioActivoFK;
    }

    public int getMedicamentoFormaFarmaceuticaFK() {
        return medicamentoFormaFarmaceuticaFK;
    }

    public void setMedicamentoFormaFarmaceuticaFK(int medicamentoFormaFarmaceuticaFK) {
        this.medicamentoFormaFarmaceuticaFK = medicamentoFormaFarmaceuticaFK;
    }

    public int getMedicamentoConcentracionFK() {
        return medicamentoConcentracionFK;
    }

    public void setMedicamentoConcentracionFK(int medicamentoConcentracionFK) {
        this.medicamentoConcentracionFK = medicamentoConcentracionFK;
    }

    public int getMedicamentoUnidadMedidaFK() {
        return medicamentoUnidadMedidaFK;
    }

    public void setMedicamentoUnidadMedidaFK(int medicamentoUnidadMedidaFK) {
        this.medicamentoUnidadMedidaFK = medicamentoUnidadMedidaFK;
    }

}
