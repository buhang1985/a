package iih.nm.nhr.dto.weeksched.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 表格分组数据 DTO数据 
 * 
 */
public class SchedGrpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分组id
	 * @return String
	 */
	public String getId_nhr_sigrp() {
		return ((String) getAttrVal("Id_nhr_sigrp"));
	}
	/**
	 * 分组id
	 * @param Id_nhr_sigrp
	 */
	public void setId_nhr_sigrp(String Id_nhr_sigrp) {
		setAttrVal("Id_nhr_sigrp", Id_nhr_sigrp);
	}
	/**
	 * 分组名称
	 * @return String
	 */
	public String getName_nhr_sigrp() {
		return ((String) getAttrVal("Name_nhr_sigrp"));
	}
	/**
	 * 分组名称
	 * @param Name_nhr_sigrp
	 */
	public void setName_nhr_sigrp(String Name_nhr_sigrp) {
		setAttrVal("Name_nhr_sigrp", Name_nhr_sigrp);
	}
	/**
	 * 行数据
	 * @return FArrayList
	 */
	public FArrayList getRowlist() {
		return ((FArrayList) getAttrVal("Rowlist"));
	}
	/**
	 * 行数据
	 * @param Rowlist
	 */
	public void setRowlist(FArrayList Rowlist) {
		setAttrVal("Rowlist", Rowlist);
	}
}