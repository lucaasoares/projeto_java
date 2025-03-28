
        package br.com.fecaf.controller;

import br.com.fecaf.model.Circulo;
import br.com.fecaf.model.Retangulo;
import br.com.fecaf.model.Triangulo;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void executarMenu() {

        boolean exit = false;

        Circulo circulo = new Circulo();

        while (!exit) {


            System.out.println("//");
            System.out.println("/*        Geometria       */");
            System.out.println("//");
            System.out.println("/* 1 - Circulo            */");
            System.out.println("/* 2 - Retangulo          */");
            System.out.println("/* 3 - Triangulo          */");
            System.out.println("/* 4 - Sair               */");
            System.out.println("//");
            System.out.println("Informe a opção desejada:   ");


            int optionUser = scanner.nextInt();

            switch (optionUser) {
                case 1:

                    boolean exitCirculo = false;

                    boolean validaCadastro = false;


                    while (!exitCirculo) {

                        System.out.println("/*/");
                        System.out.println("/*      Circulo                */");
                        System.out.println("/*/");
                        System.out.println("1- Cadrastar Circulo           */");
                        System.out.println("2- Calcular Area               */");
                        System.out.println("3- Calcular Perimetro          */");
                        System.out.println("4- Sair                        */");
                        System.out.println("/*/");

                        System.out.println("Escolha uma opção: ");

                        int optionCirculo = scanner.nextInt();






                        switch (optionCirculo) {
                            case 1:
                                System.out.println("Cadastrando Circulo...");
                                validaCadastro = circulo.cadastrarCirculo();
                                break;

                            case 2:
                                if (validaCadastro) {
                                    System.out.println("Calculando Area...");
                                    circulo.calculararea();
                                }   else {
                                    System.out.println("Cadastre um Circulo");

                                }
                                break;
                            case 3:
                                if(validaCadastro) {
                                    System.out.println("Calculando Perimetro...");
                                    circulo.calcularPerimetro();
                                } else {
                                    System.out.println("Cadastre um Circulo");

                                }
                                break;
                            case 4:
                                System.out.println("Voltando para Menu...");
                                exitCirculo = true;
                                break;
                            default:
                                System.out.println("Opção Invalida....");
                        }
                    }

                    break;
                case 2:

                    boolean exitRetangulo = false;


                    //esse comando cria um objeto
                    Retangulo retangulo = new Retangulo();

                    boolean validaRetangulo = false;

                    while (!exitRetangulo) {

                        System.out.println("/*/");
                        System.out.println("/*      Retângulo              */");
                        System.out.println("/*/");
                        System.out.println("1- Cadrastar Retângulo         */");
                        System.out.println("2- Calcular Area               */");
                        System.out.println("3- Calcular Perimetro          */");
                        System.out.println("4- Definir Quadrado            */");
                        System.out.println("5- Sair                        */");
                        System.out.println("/*/");

                        System.out.println("Escolha uma opção: ");

                        int optionRetangulo = scanner.nextInt();

                        switch (optionRetangulo) {

                            case 1:
                                System.out.println("/*/");
                                System.out.println("/* Cadastrando Retângulo       */");
                                System.out.println("/*/");
                                validaRetangulo = retangulo.cadastrarRetangulo();
                                System.out.println("/*/");

                                break;
                            case 2:
                                if (validaRetangulo) {
                                    System.out.println("Calculando Area...");
                                    retangulo.calcularArea();
                                }   else {
                                    System.out.println("Cadastre um Retangulo");

                                }

                                break;
                            case 3:
                                if(validaRetangulo) {
                                    System.out.println("Calculando Perimetro...");
                                    retangulo.calcularPerimetro();
                                } else {
                                    System.out.println("Cadastre um Retangulo");

                                }
                                break;

                            case 4:
                                System.out.println("/** Definindo Quadrado **/");
                                if(validaRetangulo) {
                                    retangulo.validarQuadrado();

                                }
                                break;

                            case 5:System.out.println("Voltando para Menu...");
                                exitRetangulo = true;
                                break;
                            default:
                                System.out.println("Escolha uma opção válida...");

                        }

                    }

                    break;
                case 3:
                    boolean exitTriangulo = false;


                    //esse comando cria um objeto
                    Triangulo triangulo = new Triangulo();

                    boolean validaTriangulo = false;

                    while (!exitTriangulo) {

                        System.out.println("/*/");
                        System.out.println("/*      Triangulo              */");
                        System.out.println("/*/");
                        System.out.println("1- Cadrastar Triangulo         */");
                        System.out.println("2- Calcular Area               */");
                        System.out.println("3- Calcular Perimetro          */");
                        System.out.println("4- Definindo o Tipo de Triangulo*/");
                        System.out.println("5- Definir Triangulo Retangulo */");
                        System.out.println("6- Definir Triangulo 3,4,5     */");
                        System.out.println("7- Sair                        */");
                        System.out.println("/*/");

                        System.out.println("Escolha uma opção: ");

                        int optionTriangulo = scanner.nextInt();

                        switch (optionTriangulo) {

                            case 1:
                                System.out.println("/*/");
                                System.out.println("/* Cadastrando Triangulo       */");
                                System.out.println("/*/");
                                validaTriangulo = triangulo.cadastrarTriangulo();
                                System.out.println("/*/");

                                break;
                            case 2:
                                if (validaTriangulo) {
                                    System.out.println("Calculando Area...");
                                    triangulo.calcularArea();
                                }   else {
                                    System.out.println("Cadastre um Triangulo");

                                }

                                break;
                            case 3:
                                if(validaTriangulo) {
                                    System.out.println("Calculando Perimetro...");
                                    triangulo.calcularPerimetro();
                                } else {
                                    System.out.println("Cadastre um Triangulo");

                                }
                                break;

                            case 4:
                                System.out.println("/** Definindo o Tipo de Triangulo **/");
                                if(validaTriangulo) {
                                    triangulo.definirRetangulo();

                                }
                                break;

                            case 5:
                                System.out.println("/** Verificando se é um Triangulo Retangulo **/");
                                if (validaTriangulo) {
                                    triangulo.verificarTrianguloRetangulo();
                                }

                                break;

                            case 6:
                                System.out.println("/** Verificando se é um Triangulo345 **/");
                                if (validaTriangulo) {
                                    triangulo.definirTriangulo345();
                                }

                                break;

                            case 7:System.out.println("Voltando para o Menu...");
                                exitTriangulo = true;
                                break;
                            default:
                                System.out.println("Escolha uma opção válida...");

                        }

                    }
                    break;
                case 4:
                    System.out.println("Saindo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opção Invalida...");
            }

        }
    }
}