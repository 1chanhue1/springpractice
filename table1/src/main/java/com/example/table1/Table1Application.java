package com.example.table1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SpringBootApplication
public class Table1Application {

	public static void main(String[] args) {
		SpringApplication.run(Table1Application.class,args);
		try {
			URL aURL = new URL("http://localhost:8080/board/view?id=155");
			URLConnection uc = aURL.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

			String inputLine;

			while ((inputLine = in.readLine()) != null)

				System.out.println(inputLine);
			in.close();
		} catch (IOException e) {
			System.out.println("URL에서 데이터를 읽는 중 오류가 발생 했습니다.");
		}
	}

}
