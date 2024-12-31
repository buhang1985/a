package iih.ci.mrm.dto.mrmcatalog.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 编目人待编目病案数 DTO数据 
 * 
 */
public class MrmCatalogerDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编目id
	 * @return String
	 */
	public String getId_mrmcata() {
		return ((String) getAttrVal("Id_mrmcata"));
	}
	/**
	 * 编目id
	 * @param Id_mrmcata
	 */
	public void setId_mrmcata(String Id_mrmcata) {
		setAttrVal("Id_mrmcata", Id_mrmcata);
	}
	/**
	 * 编目人id
	 * @return String
	 */
	public String getId_user_catalogue() {
		return ((String) getAttrVal("Id_user_catalogue"));
	}
	/**
	 * 编目人id
	 * @param Id_user_catalogue
	 */
	public void setId_user_catalogue(String Id_user_catalogue) {
		setAttrVal("Id_user_catalogue", Id_user_catalogue);
	}
	/**
	 * 编目人姓名
	 * @return String
	 */
	public String getName_user_catalogue() {
		return ((String) getAttrVal("Name_user_catalogue"));
	}
	/**
	 * 编目人姓名
	 * @param Name_user_catalogue
	 */
	public void setName_user_catalogue(String Name_user_catalogue) {
		setAttrVal("Name_user_catalogue", Name_user_catalogue);
	}
	/**
	 * 编目人编码
	 * @return String
	 */
	public String getCode_user_catalogue() {
		return ((String) getAttrVal("Code_user_catalogue"));
	}
	/**
	 * 编目人编码
	 * @param Code_user_catalogue
	 */
	public void setCode_user_catalogue(String Code_user_catalogue) {
		setAttrVal("Code_user_catalogue", Code_user_catalogue);
	}
	/**
	 * 待编目病案数
	 * @return String
	 */
	public String getNum_uncatalogue() {
		return ((String) getAttrVal("Num_uncatalogue"));
	}
	/**
	 * 待编目病案数
	 * @param Num_uncatalogue
	 */
	public void setNum_uncatalogue(String Num_uncatalogue) {
		setAttrVal("Num_uncatalogue", Num_uncatalogue);
	}
}