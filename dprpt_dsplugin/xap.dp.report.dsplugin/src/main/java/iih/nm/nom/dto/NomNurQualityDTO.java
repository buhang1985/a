package iih.nm.nom.dto;

/**
 * 护理质量管理 DTO数据 
 * 
 */
public class NomNurQualityDTO {
	private static final long serialVersionUID = 1L;
	
	    /** 护理质量管理主键**/
	    public String Id_nom_nurquality;    
	    /** 科室Id **/
		public String Id_dep_nur;     
		/**住院跌倒抽检人数**/
		public Integer Fall_randinspect;  
		/** 住院跌倒符合数**/
		public Integer Fall_eval;   
       /** 住院压疮抽检人数 **/  
		public Integer Press_randinspect;
		/** 住院压疮符合数 **/
		public Integer Press_eval;   
		/** 院内压疮数 **/
		public Integer Press;
		/** 跌倒数  **/
		public Integer Fall;
		/** 输液人数 **/
		public Integer Infu;  
		/** 输液反应数 **/
		public Integer Infu_react; 
		/** 输血人数 **/
		public Integer Transfusion; 
		/** 输血反应数 **/
		public Integer Transfu_react;    
		/** 不良事件上报数 **/
		public Integer Adverse_event; 
		/** 不良事件I级 **/
		public Integer Adverse_eventi; 
		/** 不良事件II级 **/
		public Integer Adverse_eventii;
		/** 不良事件三级 **/
		public Integer Adverse_eventiii; 
		/** 不良事件四级 **/
		public Integer Adverse_eventiv;  
		/** 重点环节交接人数 **/
		public Integer Imp_delivery;    
		/** 重点环节合格人数 **/
		public Integer Imp_qualified;   
		/** 急救物品 **/
		public Integer Emergency;    
		/** 完好急救物品 **/
		public Integer Com_emergency; 
		/** 操作考核人数 **/
		public Integer Operation; 
		/** 操作考核合格人数 **/
		public Integer Operat_qualified; 
		/** 流程规范抽查人数 **/
		public Integer Proce_specif; 
		/** 流程规范合格人数 **/
		public Integer Proce_qualified;
		/**健康教育项目**/
		public Integer Health_edu_item; 
		/**健康教育知晓项目 **/
		public Integer Known_health_edu;
		/** 护理规范应落实项目 **/
		public Integer Nur_specif; 
		/** 护理规范实际落实 **/
		public Integer Nur_specif_truth; 
		/** 考核开始时间 **/
		public String Check_begintime; 
		/** 考核结束时间 **/
		public String Check_endtime;
		/** 是否上报 **/
		public String Fg_comfirm;
		public String getId_nom_nurquality() {
			return Id_nom_nurquality;
		}
		public void setId_nom_nurquality(String id_nom_nurquality) {
			Id_nom_nurquality = id_nom_nurquality;
		}
		public String getId_dep_nur() {
			return Id_dep_nur;
		}
		public void setId_dep_nur(String id_dep_nur) {
			Id_dep_nur = id_dep_nur;
		}
		public Integer getFall_randinspect() {
			return Fall_randinspect;
		}
		public void setFall_randinspect(Integer fall_randinspect) {
			Fall_randinspect = fall_randinspect;
		}
		public Integer getFall_eval() {
			return Fall_eval;
		}
		public void setFall_eval(Integer fall_eval) {
			Fall_eval = fall_eval;
		}
		public Integer getPress_randinspect() {
			return Press_randinspect;
		}
		public void setPress_randinspect(Integer press_randinspect) {
			Press_randinspect = press_randinspect;
		}
		public Integer getPress_eval() {
			return Press_eval;
		}
		public void setPress_eval(Integer press_eval) {
			Press_eval = press_eval;
		}
		public Integer getPress() {
			return Press;
		}
		public void setPress(Integer press) {
			Press = press;
		}
		public Integer getFall() {
			return Fall;
		}
		public void setFall(Integer fall) {
			Fall = fall;
		}
		public Integer getInfu() {
			return Infu;
		}
		public void setInfu(Integer infu) {
			Infu = infu;
		}
		public Integer getInfu_react() {
			return Infu_react;
		}
		public void setInfu_react(Integer infu_react) {
			Infu_react = infu_react;
		}
		public Integer getTransfusion() {
			return Transfusion;
		}
		public void setTransfusion(Integer transfusion) {
			Transfusion = transfusion;
		}
		public Integer getTransfu_react() {
			return Transfu_react;
		}
		public void setTransfu_react(Integer transfu_react) {
			Transfu_react = transfu_react;
		}
		public Integer getAdverse_event() {
			return Adverse_event;
		}
		public void setAdverse_event(Integer adverse_event) {
			Adverse_event = adverse_event;
		}
		public Integer getAdverse_eventi() {
			return Adverse_eventi;
		}
		public void setAdverse_eventi(Integer adverse_eventi) {
			Adverse_eventi = adverse_eventi;
		}
		public Integer getAdverse_eventii() {
			return Adverse_eventii;
		}
		public void setAdverse_eventii(Integer adverse_eventii) {
			Adverse_eventii = adverse_eventii;
		}
		public Integer getAdverse_eventiii() {
			return Adverse_eventiii;
		}
		public void setAdverse_eventiii(Integer adverse_eventiii) {
			Adverse_eventiii = adverse_eventiii;
		}
		public Integer getAdverse_eventiv() {
			return Adverse_eventiv;
		}
		public void setAdverse_eventiv(Integer adverse_eventiv) {
			Adverse_eventiv = adverse_eventiv;
		}
		public Integer getImp_delivery() {
			return Imp_delivery;
		}
		public void setImp_delivery(Integer imp_delivery) {
			Imp_delivery = imp_delivery;
		}
		public Integer getImp_qualified() {
			return Imp_qualified;
		}
		public void setImp_qualified(Integer imp_qualified) {
			Imp_qualified = imp_qualified;
		}
		public Integer getEmergency() {
			return Emergency;
		}
		public void setEmergency(Integer emergency) {
			Emergency = emergency;
		}
		public Integer getCom_emergency() {
			return Com_emergency;
		}
		public void setCom_emergency(Integer com_emergency) {
			Com_emergency = com_emergency;
		}
		public Integer getOperation() {
			return Operation;
		}
		public void setOperation(Integer operation) {
			Operation = operation;
		}
		public Integer getOperat_qualified() {
			return Operat_qualified;
		}
		public void setOperat_qualified(Integer operat_qualified) {
			Operat_qualified = operat_qualified;
		}
		public Integer getProce_specif() {
			return Proce_specif;
		}
		public void setProce_specif(Integer proce_specif) {
			Proce_specif = proce_specif;
		}
		public Integer getProce_qualified() {
			return Proce_qualified;
		}
		public void setProce_qualified(Integer proce_qualified) {
			Proce_qualified = proce_qualified;
		}
		public Integer getHealth_edu_item() {
			return Health_edu_item;
		}
		public void setHealth_edu_item(Integer health_edu_item) {
			Health_edu_item = health_edu_item;
		}
		public Integer getKnown_health_edu() {
			return Known_health_edu;
		}
		public void setKnown_health_edu(Integer known_health_edu) {
			Known_health_edu = known_health_edu;
		}
		public Integer getNur_specif() {
			return Nur_specif;
		}
		public void setNur_specif(Integer nur_specif) {
			Nur_specif = nur_specif;
		}
		public Integer getNur_specif_truth() {
			return Nur_specif_truth;
		}
		public void setNur_specif_truth(Integer nur_specif_truth) {
			Nur_specif_truth = nur_specif_truth;
		}
		public String getCheck_begintime() {
			return Check_begintime;
		}
		public void setCheck_begintime(String check_begintime) {
			Check_begintime = check_begintime;
		}
		public String getCheck_endtime() {
			return Check_endtime;
		}
		public void setCheck_endtime(String check_endtime) {
			Check_endtime = check_endtime;
		}
		public String getFg_comfirm() {
			return Fg_comfirm;
		}
		public void setFg_comfirm(String fg_comfirm) {
			Fg_comfirm = fg_comfirm;
		}     
		
}