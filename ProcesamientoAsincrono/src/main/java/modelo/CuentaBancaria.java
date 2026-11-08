
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Excepciones.SaldoInsuficienteException;

/**
 *
 * @author gabri
 */
public class CuentaBancaria {
    private double saldo;
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void retirar(double monto) throws SaldoInsuficienteException {

        if (monto > saldo) {
            throw new SaldoInsuficienteException("Fondo insuficiente para el retiro", monto - saldo );
        }

        saldo -= monto;
    }

    public double getSaldo(){return saldo;}
    
    }
    
class ProcesoRetiroHilo implements Runnable {

    private CuentaBancaria cuenta;
    private double monto;
    private ProcesoListener listener;

    public interface ProcesoListener {
        void onInicio();
        void onExito(double nuevoSaldo);
        void onError(String error);
    }

    public ProcesoRetiroHilo(
            CuentaBancaria cuenta,
            double monto,ProcesoListener listener) {

        this.cuenta = cuenta;
        this.monto = monto;
        this.listener = listener;
    }

    public void run() {
        listener.onInicio();

        try {
            Thread.sleep(2000);

            cuenta.retirar(monto);

            listener.onExito(cuenta.getSaldo());

        } catch (SaldoInsuficienteException e) {
            listener.onError(
                e.getMessage() + " | Falta: $ " + e.getMontoFaltante()
            );

        } catch (InterruptedException e) {
            listener.onError("El proceso concurrente fue interrumpido"
            );
        }
    }
}