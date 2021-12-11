package br.com.devotaku.shared.validation.exception;

public record Field(String fieldName, String message, Object value) {
}
