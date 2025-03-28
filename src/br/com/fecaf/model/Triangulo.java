
        package br.com.fecaf.model;

import java.util.Scanner;

public class Triangulo {
    public double base, altura, lado2, lado3, area, perimetro, hipotenusa;

    Scanner scanner = new Scanner(System.in);

    public boolean cadastrarTriangulo() {
        System.out.println("/*/");
        System.out.println("/* Cadastrar triangulo  */");
        System.out.println("/*/");
        System.out.print("Informe a base: ");
        base = scanner.nextDouble();
        System.out.println("/*/");
        System.out.println("Informe o lado 2: ");
        lado2 = scanner.nextDouble();
        System.out.println("Informe o lado 3: ");
        lado3 = scanner.nextDouble();
        System.out.println("Informe a altura: ");
        altura = scanner.nextDouble();

        return true;
    }

    public void calcularArea() {
        System.out.println("/* Calculando Area");
        area = (base * altura) / 2;
        System.out.println("A area é: " + area);

    }

    public void calcularPerimetro() {
        System.out.println("/*  Calculando Perimetro  */");
        perimetro = base + lado2 + lado3;
        System.out.println("O perimetro é: " + perimetro);

    }

    //Aqui começou a desandar o projeto,

    /** Definir tipo de Triangulo*/

    /** Equilatero - Escaleno - Isosceles */

    public void definirRetangulo() {
        System.out.println("/* Definindo Tipo Triângulo */");

        if (base == lado2 && base == lado3) {
            System.out.println("Esse triangulo é um triangulo Equilátero...");
        } else if (base != lado2 && base != lado3 && lado2 != lado3) {

        } else {
            System.out.println("Esse triangulo é um triangulo Isosceles...");
        }

    }

    public void verificarTrianguloRetangulo() {
        double[] lados = {base, lado2, lado3};
        java.util.Arrays.sort(lados); // Ordena os lados para garantir que o maior seja a hipotenusa, bnecessario importar
        //o java.util.Arrays.sort, se não o (lados) não funciona.

        double a = lados[0];
        double b = lados[1];
        double c = lados[2]; // Maior lado, considerado a hipotenusa

        if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
            System.out.println("/*/");
            System.out.println("O triângulo é retângulo.");
        } else {
            System.out.println("/*/");
            System.out.println("O triângulo não é retângulo.");
        }
    }
    public void definirTriangulo345() {

        // Lista os lados do triangulo para ver se os lados estão sendo comparados da forma certa. Se n tiver comparando da forma certa fudeu né.

        double[] lados = {lado2, lado3, base};
        java.util.Arrays.sort(lados);

        double[] triangulo3_4_5 = {3, 4, 5};

        // Calcula a proporção do triangulo para ver se o triangulo que foi cadastrado usando o case1 é um triangulo 3,4,5.

        double triangulo1 = lados[0] / triangulo3_4_5[0];
        double triangulo2 = lados[1] / triangulo3_4_5[1];
        double triangulo3 = lados[2] / triangulo3_4_5[2];

        // Vê se os triangulos estão proporcionais.

        if (triangulo1 == triangulo2 && triangulo2 == triangulo3) {
            System.out.println("O Triangulo é um Triangulo 3-4-5.");
        } else {
            System.out.println("O Triangulo não é um Triangulo 3-4-5.");
         }
        }
    }
        // No final desse codigo, o que eu fiz basicamente foi rezar mto e pedir ajuda pro chatGPT pra ele me explicar as partes que eu não tava entendendo,
        // sendo mais especificio, a parte dos vetores, percebi que tenho uma grande dificuldade em trabalhar com vetores, é uma boa começar a treinar isso.