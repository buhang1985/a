package iih.bd.srv.mrmtype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrmtype.d.desc.MrmTypeMrtpDODesc;
import java.math.BigDecimal;

/**
 * 病案分类数据集对照 DO数据 
 * 
 */
public class MrmTypeMrtpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_BD_MRM_MRTP= "Id_bd_mrm_mrtp";
	//病案分类主键
	public static final String ID_BD_MRM_TP= "Id_bd_mrm_tp";
	//数据集主键
	public static final String ID_SET= "Id_set";
	//数据集编码
	public static final String DATASET_CODE= "Dataset_code";
	//数据集名称
	public static final String DATASET_NAME= "Dataset_name";
	//拼音
	public static final String DATASET_PYCODE= "Dataset_pycode";
	//五笔
	public static final String DATASET_WBCODE= "Dataset_wbcode";
	//助记码
	public static final String DATASET_MNECODE= "Dataset_mnecode";
	//数据集描述
	public static final String DATASET_DES= "Dataset_des";
	//数据集分类主键
	public static final String DATASET_SETCA= "Dataset_setca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_bd_mrm_mrtp() {
		return ((String) getAttrVal("Id_bd_mrm_mrtp"));
	}	
	/**
	 * 主键
	 * @param Id_bd_mrm_mrtp
	 */
	public void setId_bd_mrm_mrtp(String Id_bd_mrm_mrtp) {
		setAttrVal("Id_bd_mrm_mrtp", Id_bd_mrm_mrtp);
	}
	/**
	 * 病案分类主键
	 * @return String
	 */
	public String getId_bd_mrm_tp() {
		return ((String) getAttrVal("Id_bd_mrm_tp"));
	}	
	/**
	 * 病案分类主键
	 * @param Id_bd_mrm_tp
	 */
	public void setId_bd_mrm_tp(String Id_bd_mrm_tp) {
		setAttrVal("Id_bd_mrm_tp", Id_bd_mrm_tp);
	}
	/**
	 * 数据集主键
	 * @return String
	 */
	public String getId_set() {
		return ((String) getAttrVal("Id_set"));
	}	
	/**
	 * 数据集主键
	 * @param Id_set
	 */
	public void setId_set(String Id_set) {
		setAttrVal("Id_set", Id_set);
	}
	/**
	 * 数据集编码
	 * @return String
	 */
	public String getDataset_code() {
		return ((String) getAttrVal("Dataset_code"));
	}	
	/**
	 * 数据集编码
	 * @param Dataset_code
	 */
	public void setDataset_code(String Dataset_code) {
		setAttrVal("Dataset_code", Dataset_code);
	}
	/**
	 * 数据集名称
	 * @return String
	 */
	public String getDataset_name() {
		return ((String) getAttrVal("Dataset_name"));
	}	
	/**
	 * 数据集名称
	 * @param Dataset_name
	 */
	public void setDataset_name(String Dataset_name) {
		setAttrVal("Dataset_name", Dataset_name);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getDataset_pycode() {
		return ((String) getAttrVal("Dataset_pycode"));
	}	
	/**
	 * 拼音
	 * @param Dataset_pycode
	 */
	public void setDataset_pycode(String Dataset_pycode) {
		setAttrVal("Dataset_pycode", Dataset_pycode);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getDataset_wbcode() {
		return ((String) getAttrVal("Dataset_wbcode"));
	}	
	/**
	 * 五笔
	 * @param Dataset_wbcode
	 */
	public void setDataset_wbcode(String Dataset_wbcode) {
		setAttrVal("Dataset_wbcode", Dataset_wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getDataset_mnecode() {
		return ((String) getAttrVal("Dataset_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Dataset_mnecode
	 */
	public void setDataset_mnecode(String Dataset_mnecode) {
		setAttrVal("Dataset_mnecode", Dataset_mnecode);
	}
	/**
	 * 数据集描述
	 * @return String
	 */
	public String getDataset_des() {
		return ((String) getAttrVal("Dataset_des"));
	}	
	/**
	 * 数据集描述
	 * @param Dataset_des
	 */
	public void setDataset_des(String Dataset_des) {
		setAttrVal("Dataset_des", Dataset_des);
	}
	/**
	 * 数据集分类主键
	 * @return String
	 */
	public String getDataset_setca() {
		return ((String) getAttrVal("Dataset_setca"));
	}	
	/**
	 * 数据集分类主键
	 * @param Dataset_setca
	 */
	public void setDataset_setca(String Dataset_setca) {
		setAttrVal("Dataset_setca", Dataset_setca);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_bd_mrm_mrtp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrm_tp_mrtp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrmTypeMrtpDODesc.class);
	}
	
}