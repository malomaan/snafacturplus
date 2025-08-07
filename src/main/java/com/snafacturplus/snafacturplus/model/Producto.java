package com.snafacturplus.snafacturplus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Marco Antonio Martinez Lopez
 * Clase que representa el modelo de productos
 */

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Codigo;
    private String Nombre;
    private String Desctipcion;
    @ManyToOne
    @JoinColumn(name = "emp_id") 
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "prv_id") 
    private Proveedor proveedor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaIngreso;
    private int Cantidad;
    private int ValorUnitario;
    private double Iva;
    private double Descuento;
    private int StopMaximo;
    private int StopMinimo;
    private boolean Activo;
    private String Imagen;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDesctipcion() {
        return Desctipcion;
    }

    public void setDesctipcion(String Desctipcion) {
        this.Desctipcion = Desctipcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(int ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public double getIva() {
        return Iva;
    }

    public void setIva(double Iva) {
        this.Iva = Iva;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public int getStopMaximo() {
        return StopMaximo;
    }

    public void setStopMaximo(int StopMaximo) {
        this.StopMaximo = StopMaximo;
    }

    public int getStopMinimo() {
        return StopMinimo;
    }

    public void setStopMinimo(int StopMinimo) {
        this.StopMinimo = StopMinimo;
    }

    public boolean getActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }
    
}
