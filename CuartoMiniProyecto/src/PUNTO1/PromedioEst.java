package PUNTO1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PromedioEst {

    public static void main(String[] args) { 
        HashMap<String, Double> Calificacion_Estudiante = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de estudiantes:");
        int num_estudiantes = scanner.nextInt();

        for (int i = 0; i < num_estudiantes; i++) {
            System.out.println("Nombre del estudiante:");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            String nombre_estudiante = scanner.nextLine();

            System.out.println("Calificacion del estudiante:");
            double calificacion = scanner.nextDouble();

            Calificacion_Estudiante.put(nombre_estudiante, calificacion);
        }

        double calificacion_promedio = calcular_promedio(Calificacion_Estudiante);
        System.out.println("Calificacion Promedio: " + calificacion_promedio);

        System.out.println("Estudiante(s) con calificacion por encima del promedio:");
        for (Map.Entry<String, Double> entrada_est : Calificacion_Estudiante.entrySet()) {
            if (entrada_est.getValue() > calificacion_promedio) {
                System.out.println(entrada_est.getKey());
            }
        }

        scanner.close();
    }

    private static double calcular_promedio(Map<String, Double> Calificacion_Estudiante) {
        double sum = 0;
        int cont = 0;

        for (double calificacion : Calificacion_Estudiante.values()) {
            sum += calificacion;
            cont++;
        }

        return sum / cont;
    }
}
