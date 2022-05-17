package br.com.devotaku.userservice.domain.ports.protocols;

import static java.nio.charset.StandardCharsets.UTF_8;

public interface Encryptor {

    String encode(String source);

    String decode(String source);

    class Base64 implements Encryptor {

        private static Base64 instance;

        private final java.util.Base64.Encoder encoder;
        private final java.util.Base64.Decoder decoder;

        private Base64() {
            this.encoder = java.util.Base64.getEncoder();
            this.decoder = java.util.Base64.getDecoder();
        }

        public static Base64 getInstance() {
            if (instance == null) {
                instance = new Base64();
            }

            return instance;
        }

        @Override
        public String encode(String source) {
            return encoder.encodeToString(source.getBytes(UTF_8));
        }

        @Override
        public String decode(String source) {
            return new String(
                    decoder.decode(source),
                    UTF_8
            );
        }

    }

}
