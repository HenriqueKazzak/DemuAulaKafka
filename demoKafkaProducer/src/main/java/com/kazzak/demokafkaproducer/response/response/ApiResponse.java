package com.kazzak.demokafkaproducer.response.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;


@AllArgsConstructor
@ResponseBody
@JsonIgnoreProperties("httpStatus")
@Getter
public class ApiResponse<T> {
    private HttpStatus httpStatus;
    private String mensagem;
    private String topico;
    private T payload;

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    //builder
    public static class ApiResponseBuilder<T> {
        private HttpStatus httpStatus;
        private String mensagem;
        private String topico;
        private T payload;

        public ApiResponseBuilder<T> httpStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public ApiResponseBuilder<T> mensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public ApiResponseBuilder<T> topico(String topico) {
            this.topico = topico;
            return this;
        }

        public ApiResponseBuilder<T> payload(T payload) {
            this.payload = payload;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<>(httpStatus, mensagem, topico, payload);
        }
    }
}
