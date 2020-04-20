package com.poc.apiconsume.apiconsume.api.client.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class IntegrationConfig {
	
	@Bean
	public RestTemplate restTemplate() 
	                throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
	    TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

	    SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
	                    .loadTrustMaterial(null, acceptingTrustStrategy)
	                    .build();

	    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

	    CloseableHttpClient httpClient = HttpClients.custom()
	                    .setSSLSocketFactory(csf)
	                    .build();

	    HttpComponentsClientHttpRequestFactory requestFactory =
	                    new HttpComponentsClientHttpRequestFactory();

	    requestFactory.setHttpClient(httpClient);
	    RestTemplate restTemplate = new RestTemplate(requestFactory);
	    return restTemplate;
	 }
	
	
	/*
	 * private static final Logger LOGGER =
	 * LoggerFactory.getLogger(IntegrationConfig.class);
	 * 
	 * // Determines the timeout in milliseconds until a connection is established.
	 * private static final int CONNECT_TIMEOUT = 30000;
	 * 
	 * // The timeout when requesting a connection from the connection manager.
	 * private static final int REQUEST_TIMEOUT = 30000;
	 * 
	 * // The timeout for waiting for data private static final int SOCKET_TIMEOUT =
	 * 60000;
	 * 
	 * private static final int MAX_TOTAL_CONNECTIONS = 10; private static final int
	 * DEFAULT_KEEP_ALIVE_TIME_MILLIS = 20 * 1000; //private static final int
	 * CLOSE_IDLE_CONNECTION_WAIT_TIME_SECS = 30;
	 * 
	 * 
	 * 
	 * @Bean public PoolingHttpClientConnectionManager poolingConnectionManager() {
	 * SSLContextBuilder builder = new SSLContextBuilder(); try {
	 * builder.loadTrustMaterial(null, new TrustSelfSignedStrategy()); } catch
	 * (NoSuchAlgorithmException | KeyStoreException e) {
	 * LOGGER.error("Pooling Connection Manager Initialisation failure because of "
	 * + e.getMessage(), e); }
	 * 
	 * SSLConnectionSocketFactory sslsf = null; try { sslsf = new
	 * SSLConnectionSocketFactory(builder.build()); } catch (KeyManagementException
	 * | NoSuchAlgorithmException e) {
	 * LOGGER.error("Pooling Connection Manager Initialisation failure because of "
	 * + e.getMessage(), e); }
	 * 
	 * Registry<ConnectionSocketFactory> socketFactoryRegistry =
	 * RegistryBuilder.<ConnectionSocketFactory>create() .register("https",
	 * sslsf).register("http", new PlainConnectionSocketFactory()).build();
	 * 
	 * PoolingHttpClientConnectionManager poolingConnectionManager = new
	 * PoolingHttpClientConnectionManager( socketFactoryRegistry);
	 * poolingConnectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS); return
	 * poolingConnectionManager; }
	 * 
	 * @Bean public ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
	 * return new ConnectionKeepAliveStrategy() {
	 * 
	 * @Override public long getKeepAliveDuration(HttpResponse response, HttpContext
	 * context) { HeaderElementIterator it = new BasicHeaderElementIterator(
	 * response.headerIterator(HTTP.CONN_KEEP_ALIVE)); while (it.hasNext()) {
	 * HeaderElement he = it.nextElement(); String param = he.getName(); String
	 * value = he.getValue();
	 * 
	 * if (value != null && param.equalsIgnoreCase("timeout")) { return
	 * Long.parseLong(value) * 1000; } } return DEFAULT_KEEP_ALIVE_TIME_MILLIS; } };
	 * }
	 * 
	 * @Bean public CloseableHttpClient httpClient() { RequestConfig requestConfig =
	 * RequestConfig.custom().setConnectionRequestTimeout(REQUEST_TIMEOUT)
	 * .setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
	 * 
	 * return HttpClients.custom().setDefaultRequestConfig(requestConfig)
	 * .setConnectionManager(poolingConnectionManager()).setKeepAliveStrategy(
	 * connectionKeepAliveStrategy()) .build(); }
	 * 
	 * 
	 * @Autowired CloseableHttpClient httpClient;
	 * 
	 * @Bean public RestTemplate restTemplate() { RestTemplate restTemplate = new
	 * RestTemplate(clientHttpRequestFactory()); return restTemplate; }
	 * 
	 * @Bean public HttpComponentsClientHttpRequestFactory
	 * clientHttpRequestFactory() { HttpComponentsClientHttpRequestFactory
	 * clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
	 * clientHttpRequestFactory.setHttpClient(httpClient()); return
	 * clientHttpRequestFactory; }
	 */
}
