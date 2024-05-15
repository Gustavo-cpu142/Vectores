import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Loteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] numerosGenerados = new int[10];
        int[] numerosIngresados = new int[10];

        double montoApostado;
        double totalApostado = 0;
        double totalGanado = 0;

        boolean jugarDeNuevo = true;

        while (jugarDeNuevo) {
            // Generar números aleatorios
            System.out.println("Generando números aleatorios...");
            for (int i = 0; i < numerosGenerados.length; i++) {
                numerosGenerados[i] = random.nextInt(90) + 10;
            }
            System.out.println("Números generados: " + Arrays.toString(numerosGenerados));

            // Pedir números al usuario
            System.out.println("Ingrese sus números de dos dígitos:");
            for (int i = 0; i < numerosIngresados.length; i++) {
                System.out.print("Número " + (i + 1) + ": ");
                numerosIngresados[i] = scanner.nextInt();
            }

            // Pedir monto apostado
            System.out.print("Ingrese el monto a apostar: ");
            montoApostado = scanner.nextDouble();
            totalApostado += montoApostado;

            // Verificar aciertos
            int aciertos = 0;
            for (int i = 0; i < numerosGenerados.length; i++) {
                for (int j = 0; j < numerosIngresados.length; j++) {
                    if (numerosGenerados[i] == numerosIngresados[j]) {
                        aciertos++;
                        break;
                    }
                }
            }

            // Calcular ganancias
            double ganancia = 0;
            if (aciertos == 10) {
                ganancia = montoApostado * 50;
            } else if (aciertos >= 5) {
                ganancia = montoApostado * 25;
            } else if (aciertos >= 4) {
                ganancia = montoApostado * 15;
            }

            double impuesto = ganancia * 0.1;
            double montoCobrar = ganancia - impuesto;
            totalGanado += montoCobrar;

            // Imprimir resultados
            System.out.println("Números acertados: " + aciertos);
            System.out.println("Números errados: " + (10 - aciertos));
            System.out.println("Monto ganado: $" + ganancia);
            System.out.println("Impuesto: $" + impuesto);
            System.out.println("Monto a cobrar: $" + montoCobrar);

            // Preguntar si jugar de nuevo
            System.out.print("¿Desea jugar de nuevo? (S/N): ");
            String respuesta = scanner.next();
            jugarDeNuevo = respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("Si");
        }
    }
}