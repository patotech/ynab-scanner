package cl.madduck.ynab.scanner.santander;

import java.io.IOException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.madduck.ynab.scanner.santander.dao.LoginResult;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreditCardTransactionScanner implements RequestHandler<Integer, String> {

	private static final Gson GSON = new GsonBuilder().serializeNulls().create();
	private static final OkHttpClient REQUEST_CLIENT = new OkHttpClient();
	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	
	private static final String URL_LOGIN_MOVIL = "https://www.santandermovil.cl/UI.Services/api/account/login";
	private static final String URL_LOGIN_HEADER_ORIGIN_NAME = "Origin";
	private static final String URL_LOGIN_HEADER_ORIGIN_VALUE = "https://www.santandermovil.cl";
	private static final String URL_LOGIN_HEADER_REFERER_NAME = "Referer";
	private static final String URL_LOGIN_HEADER_REFERER_VALUE = "https://www.santandermovil.cl/UI.Web.Login/dist/";
	
	private static final String URL_CONSULTA_MOVIMIENTOS_NO_FACTURADOS = "https://apiper.santander.cl/appper/facade/TarjetaDeCredito/ConsultaUltimosMovimientos";

	@Override
	public String handleRequest(Integer input, Context context) {
		final RequestBody body = RequestBody.create("{\"username\":\"00130744214\",\"password\":\"8375\"}", JSON);
		final Request request = new Request.Builder()
				.url( URL_LOGIN_MOVIL )
				.header( URL_LOGIN_HEADER_ORIGIN_NAME, URL_LOGIN_HEADER_ORIGIN_VALUE )
				.header( URL_LOGIN_HEADER_REFERER_NAME, URL_LOGIN_HEADER_REFERER_VALUE )
				.post( body )
				.build();

		String jwtKey = null;
		try (Response response = REQUEST_CLIENT.newCall(request).execute()) {
			final String loginRequestBody = response.body().string();
			final LoginResult loginResult = GSON.fromJson( loginRequestBody , LoginResult.class );
			jwtKey = loginResult.getResult().getKey();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();

		return null;
	}

}
