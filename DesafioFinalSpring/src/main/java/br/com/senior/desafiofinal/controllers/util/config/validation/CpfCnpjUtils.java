/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.config.validation;

/**
 * Classe para validação de CPF ou CNPJ
 * 
 * @author Jefferson Möller
 *
 */
public class CpfCnpjUtils {
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	public static boolean isValid(String cpfCnpj) {
		return (isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj));
	}

	/**
	 * Metodo que verifica quantos digitos existe
	 * 
	 * @param str
	 * @param peso
	 * @return int
	 */
	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	/**
	 * 
	 * @param text
	 * @param character
	 * @return
	 */
	private static String padLeft(String text, char character) {
		return String.format("%11s", text).replace(' ', character);
	}

	/**
	 * Metodo que verifica se o CPF é valido com retorno Booleano
	 * 
	 * @param cpf
	 * @return Boolean
	 */
	private static boolean isValidCPF(String cpf) {
		cpf = cpf.trim().replace(".", "").replace("-", "");
		if ((cpf == null) || (cpf.length() != 11))
			return false;

		for (int j = 0; j < 10; j++)
			if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf))
				return false;

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	/**
	 * Metodo que verifica se o CNPJ é valido com retorno Booleano
	 * 
	 * @param cnpj
	 * @return Boolean
	 */

	private static boolean isValidCNPJ(String cnpj) {
		cnpj = cnpj.trim().replace(".", "").replace("-", "");
		if ((cnpj == null) || (cnpj.length() != 14))
			return false;

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}

}
