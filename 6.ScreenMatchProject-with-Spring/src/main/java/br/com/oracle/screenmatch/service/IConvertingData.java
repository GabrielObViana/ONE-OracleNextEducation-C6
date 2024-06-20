package br.com.oracle.screenmatch.service;

public interface IConvertingData {
   <T> T getData(String json,
                 Class<T> tclass);
}
