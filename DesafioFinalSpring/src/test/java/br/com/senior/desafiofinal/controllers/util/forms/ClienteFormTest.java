/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.forms;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import br.com.senior.desafiofinal.controllers.util.config.validation.CpfCnpjUtils;
import br.com.senior.desafiofinal.enuns.TipoEnum;

/**
 * @author Jefferson Möller
 *
 */
class ClienteFormTest {

	@Test
	void verificaDocumentoComCPFValido() {
		Assert.assertEquals(true, CpfCnpjUtils.isValid("36681454909"));
	}

	@Test
	void verificaDocumentoComCPFInvalido() {
		Assert.assertEquals(false, CpfCnpjUtils.isValid("36681454901"));
	}

	@Test
	void verificaDocumentoComCNPJValido() {
		Assert.assertEquals(true, CpfCnpjUtils.isValid("80680093000181"));
	}

	@Test
	void verificaDocumentoComCNPJInvalido() {
		Assert.assertEquals(false, CpfCnpjUtils.isValid("80680093000182"));
	}

	@Test
	void verificaDocumentoComCampoVazio() {
		Assert.assertEquals(false, CpfCnpjUtils.isValid(""));
	}

	@Test
	public void verificaSeCPFValidoConverteTipoEnumParaFisico() {
		TipoEnum tipo = null;
		String documento = "36681454909";
		if (CpfCnpjUtils.isValid(documento)) {
			if (documento.length() == 11) {
				tipo = TipoEnum.FISICO;
			}
		}
		Assert.assertEquals(TipoEnum.FISICO, tipo);
	}

	@Test
	public void verificaSeCNPJValidoConverteTipoEnumParaJURIDICO() {
		TipoEnum tipo = null;
		String documento = "36681454909";
		if (CpfCnpjUtils.isValid(documento)) {
			if (documento.length() == 11) {
				tipo = TipoEnum.FISICO;
			}
			tipo = TipoEnum.JURIDICO;
		}
		Assert.assertEquals(TipoEnum.JURIDICO, tipo);

	}

}
