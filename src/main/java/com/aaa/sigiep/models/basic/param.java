package com.aaa.sigiep.models.basic;

public class param {

    public Integer Id_Unico;
    public String Anno;
    public Float SalarioMinimo;
    public Float MinDepreciacion;
    public Float Uvt;
    public Float CajaMenor;
    public Integer EstadoAnno;
    public Integer Compania;
    public Integer MinimaCuantia;
    public Integer MenorCuantia;
    public Integer PorcentajeTrabajoExcenta;
    public Integer PorcentajeCifraControl;

    public param(Integer Id_Unico, String Anno, Float SalarioMinimo, Float MinDepreciacion, Float Uvt, Float CajaMenor, Integer EstadoAnno, Integer Compania, Integer MinimaCuantia, Integer MenorCuantia, Integer PorcentajeTrabajoExcenta, Integer PorcentajeCifraControl) {
        this.Id_Unico = Id_Unico;
        this.Anno = Anno;
        this.SalarioMinimo = SalarioMinimo;
        this.MinDepreciacion = MinDepreciacion;
        this.Uvt = Uvt;
        this.CajaMenor = CajaMenor;
        this.EstadoAnno = EstadoAnno;
        this.Compania = Compania;
        this.MinimaCuantia = MinimaCuantia;
        this.MenorCuantia = MenorCuantia;
        this.PorcentajeTrabajoExcenta = PorcentajeTrabajoExcenta;
        this.PorcentajeCifraControl = PorcentajeCifraControl;
    }

    public param(String Anno, Float SalarioMinimo, Float MinDepreciacion, Float Uvt, Float CajaMenor, Integer EstadoAnno, Integer Compania, Integer MinimaCuantia, Integer MenorCuantia, Integer PorcentajeTrabajoExcenta, Integer PorcentajeCifraControl) {
        this.Anno = Anno;
        this.SalarioMinimo = SalarioMinimo;
        this.MinDepreciacion = MinDepreciacion;
        this.Uvt = Uvt;
        this.CajaMenor = CajaMenor;
        this.EstadoAnno = EstadoAnno;
        this.Compania = Compania;
        this.MinimaCuantia = MinimaCuantia;
        this.MenorCuantia = MenorCuantia;
        this.PorcentajeTrabajoExcenta = PorcentajeTrabajoExcenta;
        this.PorcentajeCifraControl = PorcentajeCifraControl;
    }

    public param() {
    }

    public Integer getId_Unico() {
        return Id_Unico;
    }

    public void setId_Unico(Integer Id_Unico) {
        this.Id_Unico = Id_Unico;
    }

    public String getAnno() {
        return Anno;
    }

    public void setAnno(String Anno) {
        this.Anno = Anno;
    }

    public Float getSalarioMinimo() {
        return SalarioMinimo;
    }

    public void setSalarioMinimo(Float SalarioMinimo) {
        this.SalarioMinimo = SalarioMinimo;
    }

    public Float getMinDepreciacion() {
        return MinDepreciacion;
    }

    public void setMinDepreciacion(Float MinDepreciacion) {
        this.MinDepreciacion = MinDepreciacion;
    }

    public Float getUvt() {
        return Uvt;
    }

    public void setUvt(Float Uvt) {
        this.Uvt = Uvt;
    }

    public Float getCajaMenor() {
        return CajaMenor;
    }

    public void setCajaMenor(Float CajaMenor) {
        this.CajaMenor = CajaMenor;
    }

    public Integer getEstadoAnno() {
        return EstadoAnno;
    }

    public void setEstadoAnno(Integer EstadoAnno) {
        this.EstadoAnno = EstadoAnno;
    }

    public Integer getCompania() {
        return Compania;
    }

    public void setCompania(Integer Compania) {
        this.Compania = Compania;
    }

    public Integer getMinimaCuantia() {
        return MinimaCuantia;
    }

    public void setMinimaCuantia(Integer MinimaCuantia) {
        this.MinimaCuantia = MinimaCuantia;
    }

    public Integer getMenorCuantia() {
        return MenorCuantia;
    }

    public void setMenorCuantia(Integer MenorCuantia) {
        this.MenorCuantia = MenorCuantia;
    }

    public Integer getPorcentajeTrabajoExcenta() {
        return PorcentajeTrabajoExcenta;
    }

    public void setPorcentajeTrabajoExcenta(Integer PorcentajeTrabajoExcenta) {
        this.PorcentajeTrabajoExcenta = PorcentajeTrabajoExcenta;
    }

    public Integer getPorcentajeCifraControl() {
        return PorcentajeCifraControl;
    }

    public void setPorcentajeCifraControl(Integer PorcentajeCifraControl) {
        this.PorcentajeCifraControl = PorcentajeCifraControl;
    }       
}
