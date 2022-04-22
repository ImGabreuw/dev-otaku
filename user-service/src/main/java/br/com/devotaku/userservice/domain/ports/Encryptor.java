package br.com.devotaku.userservice.domain.ports;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public interface Encryptor {

    String encode(String source);

    String decode(String source);

    class DefaultEncryptor implements Encryptor {

        private static DefaultEncryptor instance;

        private final Base64.Encoder encoder;
        private final Base64.Decoder decoder;

        private DefaultEncryptor() {
            this.encoder = Base64.getEncoder();
            this.decoder = Base64.getDecoder();
        }

        public static DefaultEncryptor getInstance() {
            if (instance == null) {
                instance = new DefaultEncryptor();
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
