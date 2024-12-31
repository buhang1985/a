package iih.nmr.common.dto.d;

import xap.mw.core.data.BaseDTO;
/**
 * 体征内容记录
 * @author iih
 *
 */
public class CiMrVsItmDTO extends BaseDTO {
		private static final long serialVersionUID = 1L;
		/**
		 * 服务项目ID
		 * @return
		 */
		public String getId_srv() {
			return ((String) getAttrVal("Id_srv"));
		}
		
		/**
		 * 服务项目ID
		 * @param Id_srv
		 */
		public void setId_srv(String Id_srv) {
			setAttrVal("Id_srv", Id_srv);
		}
		
		/**
		 * 显示名称
		 * @return
		 */
		public String getName() {
			return ((String) getAttrVal("Name"));
		}
		
		/**
		 * 显示名称
		 * @param Name
		 */
		public void setName(String Name) {
			setAttrVal("Name", Name);
		}
		
		/**
		 * 值
		 * @return
		 */
		public String getValue() {
			return ((String) getAttrVal("Value"));
		}
		
		/**
		 * 值
		 * @param Value
		 */
		public void setValue(String Value) {
			setAttrVal("Value", Value);
		}
		
		
		
}
