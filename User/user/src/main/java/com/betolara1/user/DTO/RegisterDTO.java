package com.betolara1.user.DTO;

public record RegisterDTO(String username, String password) {}



//public record RegisterDTO(String username, String password) {}, 
// essa sintaxe nova do Java (chamada de Record) faz parecer que o arquivo está vazio porque não tem código entre as chaves { }.

// Mas, na verdade, o Java cria tudo automaticamente para você nos bastidores: construtor, getters (username(), password()), equals, hashCode e toString.

// Se você fosse fazer do jeito "antigo" (com Class), ele ficaria assim:

// Java

// // O jeito "Record" (uma linha) faz exatamente a mesma coisa que isso aqui:
// public class RegisterDTO {
//     private String username;
//     private String password;

//     // Construtores...
//     // Getters e Setters...
// }
