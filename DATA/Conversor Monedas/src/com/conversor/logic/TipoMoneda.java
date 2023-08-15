package com.conversor.logic;

public class TipoMoneda {
        private final String nombre;
        private final String simbolo;
        private final double tasaCambio;

        public TipoMoneda(String nombre, String simbolo, double tasaCambio) {
            this.nombre = nombre;
            this.simbolo = simbolo;
            this.tasaCambio = tasaCambio;
        }
    public String toString() {
        return nombre;
    }
        public String getNombre() {
            return nombre;
        }

        public String getSimbolo() {
            return simbolo;
        }

        public double getTasaCambio() {
            return tasaCambio;
        }
     public static void mostrarListaMonedas(TipoMoneda[] tiposMoneda) {
         for (int i = 0; i < tiposMoneda.length; i++) {
             TipoMoneda moneda = tiposMoneda[i];
             System.out.println((i + 1) + ". " + moneda.getNombre() + " (" + moneda.getSimbolo() + ")");
         }
     }

        /* Arreglo con los tipos de moneda disponibles*/
        public static final TipoMoneda[] TIPOS_MONEDA = {
                new TipoMoneda("USD", "USD", 1.0),
                new TipoMoneda("COP", "COP", 4065.12),
                new TipoMoneda("TRY", "TRY", 26.98),
                new TipoMoneda("RUB", "RUB", 94.75),
                new TipoMoneda("EUR", "EUR", 0.91)
        };
    }
