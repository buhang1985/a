package iih.pe.papt.dto.pecorplistdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 团体分组列表 DTO数据 
 * 
 */
public class PeCorpGrpListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 团体预约分组主键标识
	 * @return String
	 */
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}
	/**
	 * 团体预约分组主键标识
	 * @param Id_pecorpapptgrp
	 */
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
	}
	/**
	 * 体检团体预约主键
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}
	/**
	 * 体检团体预约主键
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	/**
	 * 分组名称
	 * @return String
	 */
	public String getName_corpgroup() {
		return ((String) getAttrVal("Name_corpgroup"));
	}
	/**
	 * 分组名称
	 * @param Name_corpgroup
	 */
	public void setName_corpgroup(String Name_corpgroup) {
		setAttrVal("Name_corpgroup", Name_corpgroup);
	}
}