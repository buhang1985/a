package iih.bd.mm.comm.s;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.comm.i.ICodeGeneratorService;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.utils.log.BdMmLogUtils;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

public class CodeGeneratorServiceImpl implements ICodeGeneratorService {

	@Override
	public String generatorMMCategoryCode(String parentId) throws BizException {
		String tableName = "bd_mmca";
		String idName = "id_mmca";
		String form = "2/2/2/2";
		return generatorCode(tableName, idName, form, parentId);
	}

	private String generatorCode(String tableName, String idName, String form, String parentId) throws BizException {
		MMCategoryDO parentMmCa = null;

		DAFacade daFacade = new DAFacade();
		if (StringUtils.isNotBlank(parentId)) {
			parentMmCa = (MMCategoryDO) daFacade.findByPK(MMCategoryDO.class, parentId);
		}

		int currentLevel = getCurrentLevel(tableName, idName, parentMmCa);
		String[] regs = form.split("/");
		if (regs == null || regs.length == 0) {
			throw new BizException("编码范式配置错误。[form:" + form + "]");
		}
		if (currentLevel >= regs.length) {
			currentLevel = regs.length - 1;
		}
		int currentLen = Integer.parseInt(regs[currentLevel]);

		String result = null;
		String code = getCurentMaxCode(tableName, parentMmCa);
		if (StringUtils.isNotBlank(code)) {
			String prefix = parentMmCa.getCode();
			String sufix = code.substring(prefix.length() + 1, code.length());
			result = prefix + leftFix(String.valueOf(Integer.parseInt(sufix) + 1), currentLen, '0');

		} else {
			code = parentMmCa != null ? parentMmCa.getCode() : "";
			result = code + leftFix("1", currentLen, '0');
		}

		return result;
	}

	/**
	 * 获取当前层级的最大编码
	 * 
	 * @param tableName
	 * @param parentMmCa
	 * @return
	 * @throws BizException
	 */
	private String getCurentMaxCode(String tableName, MMCategoryDO parentMmCa) throws BizException {
		DAFacade dao = new DAFacade();
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select max(code) code from " + tableName + " a ");
		sqlStr.append("where ");
		sqlStr.append(" a.ds = 0 ");
		if (parentMmCa == null) {
			sqlStr.append(" and a.id_parent is null ");
		} else {
			sqlStr.append(" and a.id_parent='" + parentMmCa.getId_mmca() + "' and regexp_like(a.code,'^"
					+ parentMmCa.getCode() + "[0-9]+')");
		}

		String code;
		try {
			code = (String) dao.execQuery(sqlStr.toString(), new ColumnHandler());
		} catch (DAException e) {
			BdMmLogUtils.logEx(e);
			throw new BizException(e);
		}
		return code;
	}

	private int getCurrentLevel(String tableName, String idName, MMCategoryDO parentMmCa) throws BizException {
		if (parentMmCa == null) {
			return 0;
		}

		String innerCode = parentMmCa.getInnercode();
		if (StringUtils.isBlank(innerCode)) {
			throw new BizException("父分类内码为空。");
		}
		return innerCode.length() / 4;
	}

	private String leftFix(String src, int len, char c) {
		if (StringUtils.isBlank(src)) {
			return src;
		}
		int srcLen = src.length();

		String result = src;
		for (int i = 0; i < (len - srcLen); i++) {
			result = c + result;
		}
		return result;
	}

}
