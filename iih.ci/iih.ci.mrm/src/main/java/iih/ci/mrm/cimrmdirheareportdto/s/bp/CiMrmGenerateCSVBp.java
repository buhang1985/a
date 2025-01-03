package iih.ci.mrm.cimrmdirheareportdto.s.bp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.mrarea.d.MrAreaDO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpXYDIDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpZYDiDTO;
import iih.ci.mrfp.cimrfpdto.i.ICiMrFpDTOEntRService;
import iih.ci.mrm.bp.common.CiMrMParamUtils;
import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;
import iih.ci.mrm.i.splitfouraddress.ICiMrmSplitFourAddressService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class CiMrmGenerateCSVBp {
	
	/**
	 * 获取卫生部上报的病案首页数据
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	public List<CiMrmDirHeaReportDTO> getMrmDirHeaReportDTOList(String[] idEnts) throws BizException{
		List <CiMrmDirHeaReportDTO> lists=new ArrayList<CiMrmDirHeaReportDTO>();
		lists = getDataList(idEnts,0);
		 return lists;

	}
	/**
	 * 
	 * @param idEnts
	 * @param typeFile 0-csv;1-dbf
	 * @return
	 * @throws BizException 
	 */
	public  List<CiMrmDirHeaReportDTO> getDataList(String[] idEnts,int typeFile) throws BizException
	{

		ICountryzoneRService servicecountry = ServiceFinder.find(ICountryzoneRService.class);
		List <CiMrmDirHeaReportDTO> lists=new ArrayList<CiMrmDirHeaReportDTO>();
		String id_org = Context.get().getOrgId();
		String param = CiMrMParamUtils.getMrUselessDiagnoseParam(id_org);
		String[]sp = null;
		if(!StringUtil.isEmptyWithTrim(param)){
			sp = param.split(",");
		}
		for(int i=0;i<idEnts.length;i++){
			CiMrmDirHeaReportDTO t = new CiMrmDirHeaReportDTO();
			ICiMrFpDTOEntRService cimrfpent = ServiceFinder.find(ICiMrFpDTOEntRService.class);
			ICiMrmSplitFourAddressService cimroutqry = ServiceFinder.find(ICiMrmSplitFourAddressService.class);
			CiMrFpZYDiDTO[] zy = new CiMrFpZYDiDTO[]{};
			CiMrFpXYDIDTO[] xy = new CiMrFpXYDIDTO[]{};
			CiMrFpSugDTO[] sug = new CiMrFpSugDTO[]{};
			CiMrFpDTO c = new CiMrFpDTO();
			int result = CiMrMParamUtils.GetSysParamCIMRFP_REPORT_DATA_SRC(Context.get().getOrgId());
			int typeRes = CiMrMParamUtils.GetSysParamMRM_FP_TYPE(Context.get().getOrgId());//0-西医；1-中医
			switch(result)
			{
				case 1://首页获取
					 c = cimrfpent.getMrFpPatDto(idEnts[i]);
					 sug = cimrfpent.getCiMrFpSugDTO(idEnts[i]);
					 xy = cimrfpent.getCiMrFpXYDiDTOUselessParam(idEnts[i],sp);
					 zy = cimrfpent.getCiMrFpZYDiDTOUselessParam(idEnts[i],sp);
					break;
				case 2://编目获取
					 c = cimrfpent.getMrmFpPatDTO4Cata(idEnts[i]);
					 sug = cimrfpent.getCiMrmFpSugDTO4Cata(idEnts[i]);
					 xy = cimrfpent.getCiMrmFpXYDiDTO4CataUselessParam(idEnts[i],sp);
					 zy = cimrfpent.getCiMrmFpZYDiDTO4CataUselessParam(idEnts[i],sp);
					break;
				case 3://首页和编目（编目优先）
					c = cimrfpent.getMrmFpPatDTO4Cata(idEnts[i]);
					if(null==c||null == c.getId_mrfp())
					{
						 c = cimrfpent.getMrFpPatDto(idEnts[i]);
						 sug = cimrfpent.getCiMrFpSugDTO(idEnts[i]);
						 xy = cimrfpent.getCiMrFpXYDiDTOUselessParam(idEnts[i],sp);
						 zy = cimrfpent.getCiMrFpZYDiDTOUselessParam(idEnts[i],sp);
					}
					else
					{
						 sug = cimrfpent.getCiMrmFpSugDTO4Cata(idEnts[i]);
						 xy = cimrfpent.getCiMrmFpXYDiDTO4CataUselessParam(idEnts[i],sp);
						 zy = cimrfpent.getCiMrmFpZYDiDTO4CataUselessParam(idEnts[i],sp);
					}
					break;
		     }
				
			 if(null==c||null == c.getId_mrfp())
			 {
				 continue;
			 }
			 String name_NoContrast="";
			 IUdidocRService services = ServiceFinder.find(IUdidocRService.class);
			 if(c.getId_cipathtype() == null){
				 t.setSslclj("");
			 }else{
				UdidocDO[] udidocDos = services.findByAttrValString("Id_udidoc", c.getId_cipathtype());
				t.setSslclj(udidocDos==null || udidocDos.length<=0 ?null:udidocDos[0].getCode());
			 }
			 if(c.getId_usecmp() == null){
				 t.setZyyj("");
			 }else{
				 UdidocDO[] udidocDo1 = services.findByAttrValString("Id_udidoc", c.getId_usecmp());
					t.setZyyj(udidocDo1==null || udidocDo1.length<=0 ?null:udidocDo1[0].getCode());
			 }
			if(c.getId_usecme() == null){
				t.setZyzlsb("");
			}else{
				UdidocDO[] udidocDo2 = services.findByAttrValString("Id_udidoc", c.getId_usecme());
				t.setZyzlsb(udidocDo2==null || udidocDo2.length<=0 ?null:udidocDo2[0].getCode());
			}
			if(c.getId_usecmdt() == null){
				t.setZyzljs("");
			}else{
				UdidocDO[] udidocDo3 = services.findByAttrValString("Id_udidoc", c.getId_usecmdt());
				t.setZyzljs(udidocDo3==null || udidocDo3.length<=0 ?null:udidocDo3[0].getCode());
			}
			if(c.getId_dnur() == null){
				t.setBzsh("");
			}else{
				UdidocDO[] udidocDo4 = services.findByAttrValString("Id_udidoc", c.getId_dnur());
				t.setBzsh(udidocDo4==null || udidocDo4.length<=0 ?null:udidocDo4[0].getCode());
			}
			if(c.getAllergic_drugs()==null){
				t.setGmyw("");
			}else{
				t.setGmyw(c.getAllergic_drugs());
			}
			if(c.getId_aut_dead_pat() == null){
				t.setSj("");
			}else{
				t.setSj(c.getId_aut_dead_pat());
			}
			t.setSwhzsj(t.getSj());
			// 血型
			if(c.getId_blood_type()==null){
				t.setXx("");
			}else{
				t.setXx(c.getId_blood_type());
			}	
			if(c.getId_rh_type()==null){
				t.setRh("");
			}else{
				t.setRh(c.getId_rh_type());
			}
			if(c.getId_qom_record()==null){
				t.setBazl("");
			}else{
				t.setBazl(c.getId_qom_record());
			}
			if(c.getOut_hos_mode()==null){
				t.setLyfs("");
			}else{
				t.setLyfs(c.getOut_hos_mode());
			}
			if(c.getId_is_have_inhos_plan()==null){
				t.setZzyjh("");
				t.setSfzzyjh("");
			}else{
				t.setSfzzyjh(c.getId_is_have_inhos_plan());
				t.setZzyjh(c.getId_is_have_inhos_plan());					
			}
			if(c.getId_nation()==null){
				t.setMz("");
			}else{
				UdidocDO[] udidocDo12 = services.findByAttrValString("Id_udidoc", c.getId_nation());
				if(Integer.parseInt(udidocDo12[0].getCode()) == 97){
					t.setMz("99");
				}else{
					t.setMz(udidocDo12==null  || udidocDo12.length<=0 ?null:udidocDo12[0].getCode());
				}					
			}
			if(c.getId_country()==null){
				t.setGj("");
			}else{
				CountryZoneDO [] coun = servicecountry.findByAttrValString("Id_countryzone", c.getId_country());
				t.setGj(coun==null?null:"CHN");
			}
			DateFormat format2 = new  SimpleDateFormat("yyyyMMdd");
			DateFormat format3 = new SimpleDateFormat("HH");
			if(typeFile == 0)//DBF文件中填写病案号，CSV文件中填写机构名称
				 t.setUsername(c.getName_org());
			else
				t.setUsername(c.getCode_amr_ip());
		
		
		// 医疗付款方式
		String sd_pay_method="";
		if(c.getSd_pay_method() != null && !"".equals(c.getSd_pay_method()));
		{
			sd_pay_method=c.getSd_pay_method();
		}		
        List<String> paylist=new ArrayList<String>();
        paylist.add(sd_pay_method);
		List<ValueContrastDetailDO> paylist2= dataContrastClassify(paylist,"ylfkfs");
		if(paylist2!=null && paylist2.size()>0){
			t.setYlfkfs(paylist2.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(sd_pay_method)){
				t.setYlfkfs(sd_pay_method);
				name_NoContrast+=" 医疗付款方式—"+sd_pay_method;
			}
		}
			
		
		t.setJkkh(c.getHealth_card_id());	
		t.setZycs(c.getN_times_inhospital()==null?null:c.getN_times_inhospital().toString());
		t.setBah(c.getCode_amr_ip());
		t.setXm(c.getName_pat());
		t.setXb(c.getSd_sex());
		if(c.getDt_birth_pat() != null){
			
			t.setCsrq(c.getDt_birth_pat().toString( TimeZone.getDefault(), format2));
		}
		if(c.getAge_month() != "+/30"){
			t.setBzyzs_nl(c.getAge_month());
			t.setBzyzsnl(c.getAge_month());
		}else{
			t.setBzyzs_nl("");
			t.setBzyzsnl("");
		}
		String nls = StringUtils.substringBefore(c.getAge(), "岁");
		if(!nls.equals("-")&&!nls.equals("")&&nls!= null){
			t.setNl(nls);
		}else{
			t.setNl("0");
		}
		t.setXsetz(c.getBirth_weight()==null?null:c.getBirth_weight().toString());
		t.setXsecstz(t.getXsetz());
		t.setXserytz(c.getAddmission_weight()==null?null:c.getAddmission_weight().toString());
		t.setCsd(c.getAddr_born());
		//t.setCsd_sg(c.getAddr_born());
		MrAreaDO [] mrarea = cimroutqry.getLevelFourAddressBySd(c.getSd_addr_born());
		t.setCsd_sg(mrarea[0].getCode() == null  ? null : mrarea[0].getCode());
		String asd = t.getCsd_sg();
		t.setCsd_si(mrarea[1].getCode() == null  ? null : mrarea[1].getCode());
		t.setCsd_qx(mrarea[2].getCode() == null  ? null : mrarea[2].getCode());
		t.setCsd_dz(mrarea[3].getCode() == null  ? null : mrarea[3].getCode());
		MrAreaDO [] mrareaGg = cimroutqry.getLevelFourAddressBySd(c.getSd_addr_origin());
		t.setGg(c.getAddr_origin());
		t.setGg_sg(mrareaGg[0].getCode() == null ? null : mrareaGg[0].getCode());
		t.setGg_si(mrareaGg[1].getCode() == null ? null : mrareaGg[1].getCode());
		t.setSfzh(c.getId_code());
		
		//身份证件类别
		String sfzlb = "";
		if(c.getSd_idtp() != null && !"".equals(c.getSd_idtp())){
			sfzlb = c.getSd_idtp();
		}
		List<String>sfzlist = new ArrayList<String>();
		sfzlist.add(sfzlb);
		List<ValueContrastDetailDO> sfzlist2= dataContrastClassify(sfzlist,"sfzlb");
		if(sfzlist2 != null && sfzlist2.size()>0){
			t.setSfzjlb(sfzlist2.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(sfzlb)){
				t.setSfzjlb(sfzlb);
				name_NoContrast+=" 身份证类别-"+sfzlb;
			}
		}
	
		// 职业
		String sd_occu="";
		if(c.getSd_occu() != null && !"".equals(c.getSd_occu()));
		{
			sd_occu=c.getSd_occu();
		}		
        List<String> occulist=new ArrayList<String>();
        occulist.add(sd_occu);
		List<ValueContrastDetailDO> occulist2= dataContrastClassify(occulist,"zy");
		if(occulist2!=null && occulist2.size()>0){
			t.setZy(occulist2.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(sd_occu)){
				t.setZy((sd_occu));
				name_NoContrast+=" 职业—"+sd_occu;
			}
		}
		
		// 婚姻
		String sd_marry="";
		if(c.getSd_marry() != null && !"".equals(c.getSd_marry()));
		{
			sd_marry=c.getSd_marry();
		}		
        List<String> marrylist=new ArrayList<String>();
        marrylist.add(sd_marry);
		List<ValueContrastDetailDO> marrylist2= dataContrastClassify(marrylist,"hy");
		if(marrylist2!=null && marrylist2.size()>0){
			t.setHy(marrylist2.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(sd_marry)){
				t.setHy((sd_marry));
				name_NoContrast+=" 婚姻—"+sd_marry;
			}
		}
		
		
		MrAreaDO [] mrareaXzz = cimroutqry.getLevelFourAddressBySd(c.getSd_addr_now());
		t.setXzz(c.getAddr_now());
		t.setXzz_sg(mrareaXzz[0].getCode() == null ? null : mrareaXzz[0].getCode());
		t.setXzz_si(mrareaXzz[1].getCode() == null ? null : mrareaXzz[1].getCode());
		t.setXzz_qx(mrareaXzz[2].getCode() == null ? null : mrareaXzz[2].getCode());
		t.setXzz_dz(mrareaXzz[3].getCode() == null ? null : mrareaXzz[3].getCode());
		t.setDh(c.getTel_addr_now());
		t.setYb1(c.getZip_addr_now());
		MrAreaDO [] mrareaHkdz = cimroutqry.getLevelFourAddressBySd(c.getSd_addr_cencus());
		t.setHkdz(c.getAddr_cencus());
		t.setHkdz_sg(mrareaHkdz[0].getCode() == null ? null : mrareaHkdz[0].getCode());
		t.setHkdz_si(mrareaHkdz[1].getCode() == null ? null : mrareaHkdz[1].getCode());
		t.setHkdz_qx(mrareaHkdz[2].getCode() == null ? null : mrareaHkdz[2].getCode());
		t.setHkdz_dz(mrareaHkdz[3].getCode() == null ? null : mrareaHkdz[3].getCode());
		
		t.setYb2(c.getZip_addr_cencus());
		MrAreaDO [] mrareaGzdz = cimroutqry.getLevelFourAddressBySd(c.getSd_addr_work());
		t.setGzdwjdz(c.getAddr_work());
		t.setGzdwjdz_sg(mrareaGzdz[0].getCode() == null ? null : mrareaGzdz[0].getCode());
		t.setGzdwjdz_si(mrareaGzdz[1].getCode() == null ? null : mrareaGzdz[1].getCode());
		t.setGzdwjdz_qx(mrareaGzdz[2].getCode() == null ? null : mrareaGzdz[2].getCode());
		t.setGzdwjdz_dz(mrareaGzdz[3].getCode() == null ? null : mrareaGzdz[3].getCode());
		t.setGzdwjdzmc(c.getWorkunit() == null ? null : c.getWorkunit());
		t.setDwdh(c.getDel_addr_work());
		t.setYb3(c.getZip_addr_work());
		t.setLxrxm(c.getName_cont());
		if(c.getSd_conttp() == "8" || c.getSd_conttp() == "9"){
			t.setGx("8");
		}else if(c.getSd_conttp() == "13"){
			t.setGx("0");
		}else{
			t.setGx(c.getSd_conttp());
		}
		MrAreaDO [] mrareaDz = cimroutqry.getLevelFourAddressBySd(c.getSd_addr_cont());
		t.setDz(c.getAddr_cont());
		t.setDz_sg(mrareaDz[0].getCode() == null ? null : mrareaDz[0].getCode());
		t.setDz_si(mrareaDz[1].getCode() == null ? null : mrareaDz[1].getCode());
		t.setDz_qx(mrareaDz[2].getCode() == null ? null : mrareaDz[2].getCode());
		t.setDz_dz(mrareaDz[3].getCode() == null ? null : mrareaDz[3].getCode());
		t.setDh1(c.getTel_cont());
		t.setZzyljgmc(c.getName_otherinst());
		t.setZkkb1(null);
		t.setZkkb2(null);
		t.setZgzdyj(c.getName_hightestdi());
		t.setTjhl_t(c.getSuperlev_nur_days());
		t.setYjhl_t(c.getOnelev_nur_days());
		t.setEjhl_t(c.getTwolev_nur_days());
		t.setSjhl_t(c.getThreelev_nur_days());
		t.setYlzz(c.getName_team_doc());
		t.setDh2(t.getDh1());
		t.setRytj(c.getSd_referalsrc());
		t.setZllb(c.getSd_curecategory());
		if(c.getDt_acpt() != null){
			t.setRysj(c.getDt_acpt().toString(TimeZone.getDefault(), format2));
			t.setRysj_s(c.getDt_acpt().toString(TimeZone.getDefault(), format3));//第34行   时   不知道是哪个代码
		}
		t.setRysjs(t.getRysj_s());
		
		
		// 入院科别
 		String rykb=c.getSd_dep_phyadm();
		// 转科科别
		String zkkb=c.getSd_dep_trans();
		// 出院科别
		String cykb=c.getSd_dep_phydisc();
		
        List<ValueContrastDetailDO> list = contrastClassify(c);
		if(list!=null && list.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list){
				if(rykb!=null && rykb.equals(valueDetailDo.getCode_source())){
					t.setRykb(valueDetailDo.getCode_goal());
				}
				if(zkkb!=null && zkkb.equals(valueDetailDo.getCode_source())){
					t.setZkkb(valueDetailDo.getCode_goal());
				}
	            if(cykb!=null && cykb.equals(valueDetailDo.getCode_source())){
					t.setCykb(valueDetailDo.getCode_goal());
				}
			}
		}	
		if(!StringUtil.isEmptyWithTrim(rykb) && StringUtil.isEmptyWithTrim(t.getRykb())){
			t.setRykb(rykb);
			name_NoContrast+=" 入院科别"+rykb;
		}
		if(!StringUtil.isEmptyWithTrim(zkkb) && StringUtil.isEmptyWithTrim(t.getZkkb())){
			t.setZkkb(zkkb);
			name_NoContrast+=" 转科科别"+zkkb;
		}
		if(!StringUtil.isEmptyWithTrim(cykb) && StringUtil.isEmptyWithTrim(t.getCykb())){
			t.setCykb(cykb);
			name_NoContrast+=" 出院科别"+cykb;
		}
			
		
		t.setRybf(c.getName_in_bed());
	
		if(c.getDt_end() != null){
			t.setCysj(c.getDt_end().toString(TimeZone.getDefault(), format2));
			t.setCysj_s(c.getDt_end().toString(TimeZone.getDefault(), format3));//出院时间    时   39行
		}
		t.setCysjs(t.getCysj_s());
		
		//测试
		
		t.setCybf(c.getName_out_bed());
		
		t.setSjzy(c.getHosdays()==null?null:c.getHosdays().toString());
		t.setSjzyts(t.getSjzy());
		
					
		// 门急诊诊断（中医）
		String sd_zyzd=c.getSd_outp_cm_di();
		
		// 门急诊诊断西医诊断
		String sd_xyzd=c.getSd_outp_emer_di();	
		// 中毒的外部原因疾病编码
		String sd_wbyy = "";
		// 病理诊断的疾病编码
		String sd_blh = "";
//		FBoolean SW = FBoolean.FALSE;
//		FBoolean SB = FBoolean.FALSE;
//		if(sp != null){
//			for (String str : sp) {
//				if(!str.equals(c.getSd_iioutreason())){
//					SW = FBoolean.TRUE;
//				}
//				if(!str.equals(c.getSd_dipathology())){
//					SB = FBoolean.TRUE;
//				}
//			}
//		}
//		if(!SW.equals(FBoolean.TRUE)){
			sd_wbyy=c.getSd_iioutreason();
//		}
//		if(!SB.equals(FBoolean.TRUE)){
			sd_blh=c.getSd_dipathology();
//		}
		
		t.setBlh(c.getNum_patho());
			
		
		String sd_zzy="";
		String sd_zzy1="";
		String sd_zzy2="";
		String sd_zzy3="";
		String sd_zzy4="";
		String sd_zzy5="";
		String sd_zzy6="";
		String sd_zzy7="";	
		FBoolean SZ = FBoolean.FALSE;
		if(zy.length>0){
			if(!SZ.equals(FBoolean.TRUE)){
				//主病出院中医诊断
				sd_zzy=zy[0].getSd_di();
			}
			
			t.setZb_rybq(zy[0].getId_dislvl_inp()==null?null:zy[0].getId_dislvl_inp().toString());//主病入院病情
		}
		
		if(zy.length>1){
			//主证1出院中医诊断
			sd_zzy1=zy[1].getSd_di();
			t.setZz_rybq1(zy[1].getId_dislvl_inp()==null?null:zy[1].getId_dislvl_inp().toString());//
		}
		
		if(zy.length>2){
			// 主证2出院中医诊断
			sd_zzy2=zy[2].getSd_di();
			t.setZz_rybq2(zy[2].getId_dislvl_inp()==null?null:zy[2].getId_dislvl_inp().toString());
		}
		
		if(zy.length>3){
			// 主证3出院中医诊断
			sd_zzy3=zy[3].getSd_di();	
			t.setZz_rybq3(zy[3].getId_dislvl_inp()==null?null:zy[3].getId_dislvl_inp().toString());
		}
		
		
		if(zy.length>4){
		    // 主证4出院中医诊断
			sd_zzy4=zy[4].getSd_di();
			t.setRybq4(zy[4].getId_dislvl_inp()==null?null:zy[4].getId_dislvl_inp().toString());
		}
		
		
		if(zy.length>5){
			// 主证5中医诊断
			sd_zzy5=zy[5].getSd_di();
			t.setZz_rybq5(zy[5].getId_dislvl_inp()==null?null:zy[5].getId_dislvl_inp().toString());
		}
		
		if(zy.length>6){
			// 主证6出院中医诊断
			sd_zzy6=zy[6].getSd_di();
			t.setZz_rybq6(zy[6].getId_dislvl_inp()==null?null:zy[6].getId_dislvl_inp().toString());
		}
		
		
		if(zy.length>7){
			// 主证7出院中医诊断
			sd_zzy7=zy[7].getSd_di();
			t.setZz_rybq7(zy[7].getId_dislvl_inp()==null?null:zy[7].getId_dislvl_inp().toString());
		}
		
			
		String sd_zxy="";
		String sd_qtxy1="";
		String sd_qtxy2="";
		String sd_qtxy3="";
		String sd_qtxy4="";
		String sd_qtxy5="";
		String sd_qtxy6="";
		String sd_qtxy7="";
		String sd_qtxy8="";
		String sd_qtxy9="";
		String sd_qtxy10="";
		String sd_qtxy11="";
		String sd_qtxy12="";
		String sd_qtxy13="";
		String sd_qtxy14="";
		String sd_qtxy15="";
		FBoolean SX = FBoolean.FALSE;
		if(xy.length>0){
			if(sp!=null){
				if(!SX.equals(FBoolean.TRUE)){
					//主病出院西医诊断
					sd_zxy=xy[0].getSd_di();
				}
			}
			
			t.setXy_rybq(xy[0].getId_dislvl_inp()==null?null:xy[0].getId_dislvl_inp().toString());
			t.setRybq(t.getXy_rybq());
		}
		
		if(xy.length>1){
			//其他诊断1出院西医诊断
			sd_qtxy1=xy[1].getSd_di();
			t.setRybq1(xy[1].getId_dislvl_inp()==null?null:xy[1].getId_dislvl_inp().toString());
		}
		
		
		if(xy.length>2){
			// 其他诊断2出院西医诊断
			sd_qtxy2=xy[2].getSd_di();
			t.setRybq2(xy[2].getId_dislvl_inp()==null?null:xy[2].getId_dislvl_inp().toString());
		}
		
		
		if(xy.length>3){
			// 其他诊断3出院西医诊断
			sd_qtxy3=xy[3].getSd_di();
			t.setRybq3(xy[3].getId_dislvl_inp()==null?null:xy[3].getId_dislvl_inp().toString());
		}
		
		
		if(xy.length>4){
			// 其他诊断4出院西医诊断
			sd_qtxy4=xy[4].getSd_di();
			t.setRybq4(xy[4].getId_dislvl_inp()==null?null:xy[4].getId_dislvl_inp().toString());
		}
		
		
		if(xy.length>5){
			// 其他诊断5出院西医诊断
			sd_qtxy5=xy[5].getSd_di();	
			t.setRybq5(xy[5].getId_dislvl_inp()==null?null:xy[5].getId_dislvl_inp().toString());
		}
		
		
		if(xy.length>6){
			// 其他诊断6西医诊断
			sd_qtxy6=xy[6].getSd_di();
			t.setRybq6(xy[6].getId_dislvl_inp()==null?null:xy[6].getId_dislvl_inp().toString());
		}
		
		
		if(xy.length>7){
			// 其他诊断7西医诊断
			sd_qtxy7=xy[7].getSd_di();
			t.setRybq7(xy[7].getId_dislvl_inp()==null?null:xy[7].getId_dislvl_inp().toString());
		}
		
		if(xy.length>8){
			sd_qtxy8=xy[8].getSd_di();
			t.setRybq8(xy[8].getId_dislvl_inp()==null?null:xy[8].getId_dislvl_inp().toString());
		}
		
		if(xy.length>9){
			sd_qtxy9=xy[9].getSd_di();
			t.setRybq9(xy[9].getId_dislvl_inp()==null?null:xy[9].getId_dislvl_inp().toString());
		}
		if(xy.length>10){
			sd_qtxy10=xy[10].getSd_di();
			t.setRybq10(xy[10].getId_dislvl_inp()==null?null:xy[10].getId_dislvl_inp().toString());
		}
		if(xy.length>11){
			sd_qtxy11=xy[11].getSd_di();
			t.setRybq11(xy[11].getId_dislvl_inp()==null?null:xy[11].getId_dislvl_inp().toString());
		}
		if(xy.length>12){
			sd_qtxy12=xy[12].getSd_di();
			t.setRybq12(xy[12].getId_dislvl_inp()==null?null:xy[12].getId_dislvl_inp().toString());
		}
		if(xy.length>13){
			sd_qtxy13=xy[13].getSd_di();
			t.setRybq13(xy[13].getId_dislvl_inp()==null?null:xy[13].getId_dislvl_inp().toString());
		}
		if(xy.length>14){
			sd_qtxy14=xy[14].getSd_di();
			t.setRybq14(xy[14].getId_dislvl_inp()==null?null:xy[14].getId_dislvl_inp().toString());
		}
		if(xy.length>15){
			sd_qtxy15=xy[15].getSd_di();
			t.setRybq15(xy[15].getId_dislvl_inp()==null?null:xy[15].getId_dislvl_inp().toString());
		}
			
		
			
        List<String> zdCode=new ArrayList<String>();
        zdCode.add(sd_zyzd);
        zdCode.add(sd_xyzd);
        zdCode.add(sd_wbyy);
        zdCode.add(sd_blh);
        
        // 中医
        zdCode.add(sd_zzy);
        zdCode.add(sd_zzy1);
        zdCode.add(sd_zzy2);
        zdCode.add(sd_zzy3);
        zdCode.add(sd_zzy4);
        zdCode.add(sd_zzy5);
        zdCode.add(sd_zzy6);
        zdCode.add(sd_zzy7);
        
        // 西医
        zdCode.add(sd_zxy);
        zdCode.add(sd_qtxy1);
        zdCode.add(sd_qtxy2);
        zdCode.add(sd_qtxy3);
        zdCode.add(sd_qtxy4);
        zdCode.add(sd_qtxy5);
        zdCode.add(sd_qtxy6);
        zdCode.add(sd_qtxy7);
        zdCode.add(sd_qtxy8);
        zdCode.add(sd_qtxy9);
        zdCode.add(sd_qtxy10);
        zdCode.add(sd_qtxy11);
        zdCode.add(sd_qtxy12);
        zdCode.add(sd_qtxy13);
        zdCode.add(sd_qtxy14);
        zdCode.add(sd_qtxy15);
        
        List<ValueContrastDetailDO> list2= dataContrastClassify(zdCode,"lczd");
        
        
		if(list2!=null && list2.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list2){
				if(!StringUtil.isEmptyWithTrim(sd_zyzd) && sd_zyzd.equals(valueDetailDo.getCode_source())){
					t.setMzd_zyzd(valueDetailDo.getValue_goal());
					if(typeRes == 1)
					{   if(c.getSd_outp_cm_di() != null){		 
							t.setJbdm(valueDetailDo.getCode_goal());//疾病代码
						}
					}
				}
				if(!StringUtil.isEmptyWithTrim(sd_xyzd) && sd_xyzd.equals(valueDetailDo.getCode_source())){
					t.setMzd_xyzd(valueDetailDo.getValue_goal());
					t.setJbbm(valueDetailDo.getCode_goal());
					//t.setMzzd(t.getMzd_xyzd());
					t.setMzzd(valueDetailDo.getValue_goal());
				}
	            if(!StringUtil.isEmptyWithTrim(sd_wbyy) && sd_wbyy.equals(valueDetailDo.getCode_source())){
	            	t.setWbyy(valueDetailDo.getValue_goal());
	            	t.setJbbm1(valueDetailDo.getCode_goal());
	            	t.setH23(t.getJbbm1());       	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_blh) && sd_blh.equals(valueDetailDo.getCode_source())){
	            	t.setBlzd(valueDetailDo.getValue_goal());
	            	t.setJbbm2(valueDetailDo.getCode_goal());
	        		t.setJbmm(t.getJbbm2());		
				}if(!StringUtil.isEmptyWithTrim(sd_zzy)&& sd_zzy.equals(valueDetailDo.getCode_source())){
					t.setZb(valueDetailDo.getValue_goal());
					t.setZb_jbbm(valueDetailDo.getCode_goal());
				}
				if(!StringUtil.isEmptyWithTrim(sd_zzy1)&& sd_zzy1.equals(valueDetailDo.getCode_source())){
					t.setZz1(valueDetailDo.getValue_goal());
					t.setZz_jbbm1(valueDetailDo.getCode_goal());
				}
	            if(!StringUtil.isEmptyWithTrim(sd_zzy2)&& sd_zzy2.equals(valueDetailDo.getCode_source())){
	            	t.setZz2(valueDetailDo.getValue_goal());    
	            	t.setZz_jbbm2(valueDetailDo.getCode_goal());     	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_zzy3)&& sd_zzy3.equals(valueDetailDo.getCode_source())){
	            	t.setZz3(valueDetailDo.getValue_goal());
	            	t.setZz_jbbm3(valueDetailDo.getCode_goal()); 
				}
	            if(!StringUtil.isEmptyWithTrim(sd_zzy4)&& sd_zzy4.equals(valueDetailDo.getCode_source())){
	            	t.setZz4(valueDetailDo.getValue_goal()); 
	            	t.setZz_jbbm4(valueDetailDo.getCode_goal()); 
				}
	            if(!StringUtil.isEmptyWithTrim(sd_zzy5)&& sd_zzy5.equals(valueDetailDo.getCode_source())){
	            	t.setZz5(valueDetailDo.getValue_goal()); 
	            	t.setZz_jbbm5(valueDetailDo.getCode_goal()); 
				}
	            if(!StringUtil.isEmptyWithTrim(sd_zzy6)&& sd_zzy6.equals(valueDetailDo.getCode_source())){
	            	t.setZz6(valueDetailDo.getValue_goal()); 
	            	t.setZz_jbbm6(valueDetailDo.getCode_goal());    
				}
	            if(!StringUtil.isEmptyWithTrim(sd_zzy7)&& sd_zzy7.equals(valueDetailDo.getCode_source())){
	            	t.setZz7(valueDetailDo.getValue_goal());  
	            	t.setZz_jbbm7(valueDetailDo.getCode_goal());  
				}
	            if(!StringUtil.isEmptyWithTrim(sd_zxy)&& sd_zxy.equals(valueDetailDo.getCode_source())){
					t.setZyzd(valueDetailDo.getValue_goal());		
					t.setZyzd_jbbm(valueDetailDo.getCode_goal());
					if(typeRes == 0)
					{
						t.setJbdm(t.getZyzd_jbbm());//疾病代码
					}
				}
				if(!StringUtil.isEmptyWithTrim(sd_qtxy1)&& sd_qtxy1.equals(valueDetailDo.getCode_source())){
					t.setQtzd1(valueDetailDo.getValue_goal());
					t.setZyzd_jbbm1(valueDetailDo.getCode_goal());
					t.setJbdm1(t.getZyzd_jbbm1());		
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy2) && sd_qtxy2.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd2(valueDetailDo.getValue_goal());
	            	t.setZyzd_jbbm2(valueDetailDo.getCode_goal());
					t.setJbdm2(t.getZyzd_jbbm2());   	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy3)&& sd_qtxy3.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd3(valueDetailDo.getValue_goal());
	            	t.setZyzd_jbbm3(valueDetailDo.getCode_goal());
					t.setJbdm3(t.getZyzd_jbbm3());   	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy4) && sd_qtxy4.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd4(valueDetailDo.getValue_goal());
					t.setZyzd_jbbm4(valueDetailDo.getCode_goal());	
					t.setJbdm4(t.getZyzd_jbbm4());     	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy5)&& sd_qtxy5.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd5(valueDetailDo.getValue_goal());
					t.setZyzd_jbbm5(valueDetailDo.getCode_goal());
					t.setJbdm5(t.getZyzd_jbbm5());   	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy6)&& sd_qtxy6.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd6(valueDetailDo.getValue_goal());
					t.setZyzd_jbbm6(valueDetailDo.getCode_goal());
					t.setJbdm6(t.getZyzd_jbbm6());   	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy7)&& sd_qtxy7.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd7(valueDetailDo.getValue_goal());
					t.setZyzd_jbbm7(valueDetailDo.getCode_goal());
					t.setJbdm7(t.getZyzd_jbbm7());   	
				}
				if(!StringUtil.isEmptyWithTrim(sd_qtxy8)&& sd_qtxy8.equals(valueDetailDo.getCode_source())){
					t.setQtzd8(valueDetailDo.getValue_goal());
					t.setJbdm8(valueDetailDo.getCode_goal()); 
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy9) && sd_qtxy9.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd9(valueDetailDo.getValue_goal());
	            	t.setJbdm9(sd_qtxy9); 
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy10)&& sd_qtxy10.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd10(valueDetailDo.getValue_goal());
	            	t.setJbdm10(valueDetailDo.getCode_goal()); 	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy11) && sd_qtxy11.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd11(valueDetailDo.getValue_goal());
	            	t.setJbdm11(valueDetailDo.getCode_goal());    	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy12)&& sd_qtxy12.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd12(valueDetailDo.getValue_goal());
	            	t.setJbdm12(valueDetailDo.getCode_goal());	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy13)&& sd_qtxy13.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd13(valueDetailDo.getValue_goal());
	            	t.setJbdm13(valueDetailDo.getCode_goal());	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy14)&& sd_qtxy14.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd14(valueDetailDo.getValue_goal());
	            	t.setJbdm14(valueDetailDo.getCode_goal());   	
				}
	            if(!StringUtil.isEmptyWithTrim(sd_qtxy15)&& sd_qtxy15.equals(valueDetailDo.getCode_source())){
	            	t.setQtzd15(valueDetailDo.getValue_goal());
	            	t.setJbdm15(valueDetailDo.getCode_goal()); 	
				}    
			}	
		}  
			
		
		if(!StringUtil.isEmptyWithTrim(sd_zyzd) && StringUtil.isEmptyWithTrim(t.getMzd_zyzd())){
			t.setMzd_zyzd(c.getName_outp_cm_di());
			if(typeRes == 1)
			{   if(c.getSd_outp_cm_di() != null){		 
					t.setJbdm(sd_zyzd);//疾病代码
				}
			}
			name_NoContrast+=" 门(急)诊诊断(中医诊断)—诊断编码"+sd_zyzd;
		}			
		if(!StringUtil.isEmptyWithTrim(sd_xyzd) && StringUtil.isEmptyWithTrim(t.getMzd_xyzd())){
			t.setMzd_xyzd(c.getName_outp_emer_di());
			t.setMzzd(c.getName_outp_emer_di());
			t.setJbbm(sd_xyzd);		
			name_NoContrast+=" 门(急)诊诊断(西医诊断)—诊断编码"+sd_xyzd;
		}		
        if(!StringUtil.isEmptyWithTrim(sd_wbyy) && StringUtil.isEmptyWithTrim(t.getWbyy())){
        	t.setWbyy(c.getName_iioutreason());
        	t.setJbbm1(sd_wbyy);
        	t.setH23(t.getJbbm1());
			name_NoContrast+=" 中毒的外部原因—诊断编码"+sd_wbyy;
		}         
        if(!StringUtil.isEmptyWithTrim(sd_blh) && StringUtil.isEmptyWithTrim(t.getBlzd())){
        	t.setBlzd(c.getName_dipathology());
        	t.setJbbm2(sd_blh);
    		t.setJbmm(t.getJbbm2());
			name_NoContrast+=" 病理诊断—诊断编码"+sd_blh;
		}        
        if(!StringUtil.isEmptyWithTrim(sd_zzy) && StringUtil.isEmptyWithTrim(t.getZb())){
        	t.setZb(zy[0].getName_di());
			t.setZb_jbbm(sd_zzy);
			name_NoContrast+=" 主病出院中医诊断—诊断编码"+sd_zzy;
		}	
        if(!StringUtil.isEmptyWithTrim(sd_zzy1) && StringUtil.isEmptyWithTrim(t.getZz1())){
        	t.setZz1(zy[1].getName_di());
			t.setZz_jbbm1(sd_zzy1);
			name_NoContrast+=" 主证1出院中医诊断—诊断编码"+sd_zzy1;
		}
        if(!StringUtil.isEmptyWithTrim(sd_zzy2) && StringUtil.isEmptyWithTrim(t.getZz2())){
        	t.setZz2(zy[2].getName_di());    
        	t.setZz_jbbm2(sd_zzy2); 
			name_NoContrast+=" 主证2出院中医诊断—诊断编码"+sd_zzy2;
		}
        if(!StringUtil.isEmptyWithTrim(sd_zzy3) && StringUtil.isEmptyWithTrim(t.getZz3())){
        	t.setZz3(zy[3].getName_di());
        	t.setZz_jbbm3(sd_zzy3); 
			name_NoContrast+=" 主证3出院中医诊断—诊断编码"+sd_zzy3;
		}
        if(!StringUtil.isEmptyWithTrim(sd_zzy4) && StringUtil.isEmptyWithTrim(t.getZz4())){
        	t.setZz4(zy[4].getName_di()); 
        	t.setZz_jbbm4(sd_zzy4);
			name_NoContrast+=" 主证4出院中医诊断—诊断编码"+sd_zzy4;
		}
        if(!StringUtil.isEmptyWithTrim(sd_zzy5) && StringUtil.isEmptyWithTrim(t.getZz5())){
        	t.setZz5(zy[5].getName_di()); 
        	t.setZz_jbbm5(sd_zzy5); 
			name_NoContrast+=" 主证5出院中医诊断—诊断编码"+sd_zzy5;
		}
        if(!StringUtil.isEmptyWithTrim(sd_zzy6) && StringUtil.isEmptyWithTrim(t.getZz6())){
        	t.setZz6(zy[6].getName_di()); 
        	t.setZz_jbbm6(sd_zzy6); 
			name_NoContrast+=" 主证6出院中医诊断—诊断编码"+sd_zzy6;
		}
        if(!StringUtil.isEmptyWithTrim(sd_zzy7) && StringUtil.isEmptyWithTrim(t.getZz7())){
        	t.setZz7(zy[7].getName_di());  
        	t.setZz_jbbm7(sd_zzy7); 
			name_NoContrast+=" 主证7出院中医诊断—诊断编码"+sd_zzy7;
		}
        if(!StringUtil.isEmptyWithTrim(sd_zxy) && StringUtil.isEmptyWithTrim(t.getZyzd())){
        	t.setZyzd(xy[0].getName_di());		
			t.setZyzd_jbbm(sd_zxy);
			if(typeRes == 0)
			{
				t.setJbdm(t.getZyzd_jbbm());//疾病代码
			}
			name_NoContrast+=" 主要诊断出院西医诊断—诊断编码"+sd_zxy;
		}
	    if(!StringUtil.isEmptyWithTrim(sd_qtxy1) && StringUtil.isEmptyWithTrim(t.getQtzd1())){
	    	t.setQtzd1(xy[1].getName_di());
			t.setZyzd_jbbm1(sd_qtxy1);
			t.setJbdm1(t.getZyzd_jbbm1());
			name_NoContrast+=" 其他诊断1出院西医诊断—诊断编码"+sd_qtxy1;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy2) && StringUtil.isEmptyWithTrim(t.getQtzd2())){
        	t.setQtzd2(xy[2].getName_di());
        	t.setZyzd_jbbm2(sd_qtxy2);
			t.setJbdm2(t.getZyzd_jbbm2()); 
			name_NoContrast+=" 其他诊断2出院西医诊断—诊断编码"+sd_qtxy2;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy3) && StringUtil.isEmptyWithTrim(t.getQtzd3())){
        	t.setQtzd3(xy[3].getName_di());
        	t.setZyzd_jbbm3(sd_qtxy3);
			t.setJbdm3(t.getZyzd_jbbm3());   
			name_NoContrast+=" 其他诊断3出院西医诊断—诊断编码"+sd_qtxy3;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy4) && StringUtil.isEmptyWithTrim(t.getQtzd4())){
        	t.setQtzd4(xy[4].getName_di());
			t.setZyzd_jbbm4(sd_qtxy4);	
			t.setJbdm4(t.getZyzd_jbbm4());     
			name_NoContrast+=" 其他诊断4出院西医诊断—诊断编码"+sd_qtxy4;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy5) && StringUtil.isEmptyWithTrim(t.getQtzd5())){
        	t.setQtzd5(xy[5].getName_di());
			t.setZyzd_jbbm5(sd_qtxy5);
			t.setJbdm5(t.getZyzd_jbbm5()); 
			name_NoContrast+=" 其他诊断5出院西医诊断—诊断编码"+sd_qtxy5;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy6) && StringUtil.isEmptyWithTrim(t.getQtzd6())){
        	t.setQtzd6(xy[6].getName_di());
			t.setZyzd_jbbm6(sd_qtxy6);
			t.setJbdm6(t.getZyzd_jbbm6());
			name_NoContrast+=" 其他诊断6出院西医诊断—诊断编码"+sd_qtxy6;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy7) && StringUtil.isEmptyWithTrim(t.getQtzd7())){
        	t.setQtzd7(xy[7].getName_di());
			t.setZyzd_jbbm7(sd_qtxy7);
			t.setJbdm7(t.getZyzd_jbbm7());
			name_NoContrast+=" 其他诊断7出院西医诊断—诊断编码"+sd_qtxy7;
		}
		if(!StringUtil.isEmptyWithTrim(sd_qtxy8) && StringUtil.isEmptyWithTrim(t.getQtzd8())){
			t.setQtzd8(xy[8].getName_di());
			t.setJbdm8(sd_qtxy8); 
			name_NoContrast+=" 其他诊断8出院西医诊断—诊断编码"+sd_qtxy8;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy9) && StringUtil.isEmptyWithTrim(t.getQtzd9())){
        	t.setQtzd9(xy[9].getName_di());
        	t.setJbdm9(sd_qtxy9); 
			name_NoContrast+=" 其他诊断9出院西医诊断—诊断编码"+sd_qtxy9;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy10) && StringUtil.isEmptyWithTrim(t.getQtzd10())){
        	t.setQtzd10(xy[10].getName_di());
        	t.setJbdm10(sd_qtxy10);
			name_NoContrast+=" 其他诊断10出院西医诊断—诊断编码"+sd_qtxy10;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy11) && StringUtil.isEmptyWithTrim(t.getQtzd11())){
        	t.setQtzd11(xy[11].getName_di());
        	t.setJbdm11(sd_qtxy11);
			name_NoContrast+=" 其他诊断11出院西医诊断—诊断编码"+sd_qtxy11;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy12) && StringUtil.isEmptyWithTrim(t.getQtzd12())){
        	t.setQtzd12(xy[12].getName_di());
        	t.setJbdm12(sd_qtxy12);
			name_NoContrast+=" 其他诊断12出院西医诊断—诊断编码"+sd_qtxy12;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy13) && StringUtil.isEmptyWithTrim(t.getQtzd13())){
        	t.setQtzd13(xy[13].getName_di());
        	t.setJbdm13(sd_qtxy13);	
			name_NoContrast+=" 其他诊断13出院西医诊断—诊断编码"+sd_qtxy13;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy14) && StringUtil.isEmptyWithTrim(t.getQtzd14())){
        	t.setQtzd14(xy[14].getName_di());
        	t.setJbdm14(sd_qtxy14);   
			name_NoContrast+=" 其他诊断14出院西医诊断—诊断编码"+sd_qtxy14;
		}
        if(!StringUtil.isEmptyWithTrim(sd_qtxy15) && StringUtil.isEmptyWithTrim(t.getQtzd15())){
        	t.setQtzd15(xy[15].getName_di());
        	t.setJbdm15(sd_qtxy15);
			name_NoContrast+=" 其他诊断15出院西医诊断—诊断编码"+sd_qtxy15;
		}     
        
        
        
     /* t.setWbyy(c.getName_iioutreason());
		t.setJbbm1(c.getSd_iioutreason());//外部损伤疾病编码
		t.setH23(t.getJbbm1());
		t.setBlzd(c.getName_dipathology());
		t.setJbbm2(c.getSd_dipathology());//病理诊断的疾病编码
		t.setJbmm(t.getJbbm2());
		t.setBlh(c.getNum_patho());*/
		t.setYwgm(c.getId_drug_allergy());
		t.setKzr(c.getDirofdept());
		t.setZrys(c.getName_zr_doc());
		
		t.setZzys(c.getName_zz_doc());
		t.setZyys(c.getName_zy_doc());
		t.setZrhs(c.getName_emp_nur());
		t.setJxys(c.getName_learn_doc());
		t.setSxys(c.getName_intern_doc());
		t.setBmy(c.getName_coder());
		t.setZkys(c.getName_qcp_doc());
		t.setZkhs(c.getName_qcp_nur());
		
		if(c.getQc_date()!=null){
			t.setZkrq(c.getQc_date().toString(TimeZone.getDefault(), format2));
		}
		
		
		// 8个手术操作编码
		String sd_sug="";
		String sd_sug1="";
		String sd_sug2="";
		String sd_sug3="";
		String sd_sug4="";
		String sd_sug5="";
		String sd_sug6="";
		String sd_sug7="";

		// 8个手术级别
		String sd_sug_level="";
		String sd_sug1_level="";
		String sd_sug2_level="";
		String sd_sug3_level="";
		String sd_sug4_level="";
		String sd_sug5_level="";
		String sd_sug6_level="";
		String sd_sug7_level="";
		
		// 8个切口等级
		String  sd_incision_level="";
		String  sd_incision1_level="";
		String  sd_incision2_level="";
		String  sd_incision3_level="";
		String  sd_incision4_level="";
		String  sd_incision5_level="";
		String  sd_incision6_level="";
		String  sd_incision7_level="";
		
		// 8个愈合类别
		String sd_heal_category="";
		String sd_heal1_category="";
		String sd_heal2_category="";
		String sd_heal3_category="";
		String sd_heal4_category="";
		String sd_heal5_category="";
		String sd_heal6_category="";
		String sd_heal7_category="";
		
		// 8个麻醉方式
		String sd_anaesthesia_mode="";
		String sd_anaesthesia1_mode="";
		String sd_anaesthesia2_mode="";
		String sd_anaesthesia3_mode="";
		String sd_anaesthesia4_mode="";
		String sd_anaesthesia5_mode="";
		String sd_anaesthesia6_mode="";
		String sd_anaesthesia7_mode="";
		
		//8个手术类别（手术类型）
		String sd_class_sug = "";
		String sd_class_sug1 = "";
		String sd_class_sug2 = "";
		String sd_class_sug3 = "";
		String sd_class_sug4 = "";
		String sd_class_sug5 = "";
		String sd_class_sug6 = "";
		String sd_class_sug7 = "";
		
		
		if(sug.length>0){
			// 手术操作编码
			sd_sug=sug[0].getSd_sug();	
			
			// 手术操作日期
			if(sug[0].getDt_start_sug()!= null){
				t.setSsjczrq1(sug[0].getDt_start_sug().toString(TimeZone.getDefault(), format2));
			}						
			// 手术级别 --中医
			sd_sug_level=sug[0].getSd_lvlsug();					
			
			// 手术及操作名称
			t.setSsjczmc1(sug[0].getName_sug());				
			// 术者
			t.setSz1(sug[0].getName_emp_sug());
			t.setYz1(sug[0].getName_emp_asst1());
			t.setEz1(sug[0].getName_emp_asst2());	
			
			// 切口等级
			sd_incision_level=sug[0].getSd_incitp();	
			
			// 切口愈合类别--中医
			sd_heal_category=sug[0].getSd_incicondi();
			
			// 麻醉方式
			sd_anaesthesia_mode=sug[0].getSd_anestp();
			
			// 麻醉医师
			t.setMzys1(sug[0].getName_emp_anes());
			
			// 手术类别
			sd_class_sug = sug[0].getSd_class_sug();
		}
	
		if(sug.length>1){
			// 手术操作编码
			sd_sug1=sug[1].getSd_sug();
			
			if(sug[1].getDt_start_sug()!= null){
				t.setSsjczrq2(sug[1].getDt_start_sug().toString(TimeZone.getDefault(), format2));//手术及操作日期有开始和结束不知道选哪个
			}
			
			// 手术级别 
			sd_sug1_level=sug[1].getSd_lvlsug();				

			t.setSsjczmc2(sug[1].getName_sug());	
			t.setSz2(sug[1].getName_emp_sug());
			t.setYz2(sug[1].getName_emp_asst1());
			t.setEz2(sug[1].getName_emp_asst2());
			
			// 切口等级
			sd_incision1_level=sug[1].getSd_incitp();
			
			// 愈合类别
			sd_heal1_category=sug[1].getSd_incicondi();
						
			//麻醉方式
			sd_anaesthesia1_mode=sug[1].getSd_anestp();
			
			t.setMzys2(sug[1].getName_emp_anes());
			
			// 手术类别
			sd_class_sug1 = sug[1].getSd_class_sug();
		}
	
		if(sug.length>2){
			sd_sug2=sug[2].getSd_sug();
			
			if(sug[2].getDt_start_sug()!= null){
				t.setSsjczrq3(sug[2].getDt_start_sug().toString(TimeZone.getDefault(), format2));
			}
			
			// 手术级别 
			sd_sug2_level=sug[2].getSd_lvlsug();				

			t.setSsjczmc3(sug[2].getName_sug());	
			t.setSz3(sug[2].getName_emp_sug());
			t.setYz3(sug[2].getName_emp_asst1());
			t.setEz3(sug[2].getName_emp_asst2());
			
			// 切口等级
			sd_incision2_level=sug[2].getSd_incitp();
			
			// 愈合类别
			sd_heal2_category=sug[2].getSd_incicondi();
						
			//麻醉方式
			sd_anaesthesia2_mode=sug[2].getSd_anestp();
			
			t.setMzys3(sug[2].getName_emp_anes());
			
			// 手术类别
			sd_class_sug2 = sug[2].getSd_class_sug();
							
		}
		
		if(sug.length>3){
			sd_sug3=sug[3].getSd_sug();
					
			if(sug[3].getDt_start_sug()!= null){
				t.setSsjczrq4(sug[3].getDt_start_sug().toString(TimeZone.getDefault(), format2));
			}
			
			// 手术级别 
			sd_sug3_level=sug[3].getSd_lvlsug();				

			t.setSsjczmc4(sug[3].getName_sug());	
			t.setSz4(sug[3].getName_emp_sug());
			t.setYz4(sug[3].getName_emp_asst1());
			t.setEz4(sug[3].getName_emp_asst2());
			
			// 切口等级
			sd_incision3_level=sug[3].getSd_incitp();
			
			// 愈合类别
			sd_heal3_category=sug[3].getSd_incicondi();
						
			//麻醉方式
			sd_anaesthesia3_mode=sug[3].getSd_anestp();
			
			t.setMzys4(sug[3].getName_emp_anes());
			
			// 手术类别
			sd_class_sug3 = sug[3].getSd_class_sug();
		}
		
		if(sug.length>4){
			sd_sug4=sug[4].getSd_sug();
			
			if(sug[4].getDt_start_sug()!= null){
				t.setSsjczrq5(sug[4].getDt_start_sug().toString(TimeZone.getDefault(), format2));
			}
			
			// 手术级别 
			sd_sug4_level=sug[4].getSd_lvlsug();				

			t.setSsjczmc5(sug[4].getName_sug());	
			t.setSz5(sug[4].getName_emp_sug());
			t.setYz5(sug[4].getName_emp_asst1());
			t.setEz5(sug[4].getName_emp_asst2());
			
			// 切口等级
			sd_incision4_level=sug[4].getSd_incitp();
			
			// 愈合类别
			sd_heal4_category=sug[4].getSd_incicondi();
						
			//麻醉方式
			sd_anaesthesia4_mode=sug[4].getSd_anestp();
			
			t.setMzys5(sug[4].getName_emp_anes());
			
			// 手术类别
			sd_class_sug4 = sug[4].getSd_class_sug();
		}
		
		if(sug.length>5){
			sd_sug5=sug[5].getSd_sug();
			
			if(sug[5].getDt_start_sug()!= null){
				t.setSsjczrq6(sug[5].getDt_start_sug().toString(TimeZone.getDefault(), format2));
			}
			
			// 手术级别 
			sd_sug5_level=sug[5].getSd_lvlsug();				

			t.setSsjczmc6(sug[5].getName_sug());	
			t.setSz6(sug[5].getName_emp_sug());
			t.setYz6(sug[5].getName_emp_asst1());
			t.setEz6(sug[5].getName_emp_asst2());
			
			// 切口等级
			sd_incision5_level=sug[5].getSd_incitp();
			
			// 愈合类别
			sd_heal5_category=sug[5].getSd_incicondi();
						
			//麻醉方式
			sd_anaesthesia5_mode=sug[5].getSd_anestp();
			
			t.setMzys6(sug[5].getName_emp_anes());
			
			// 手术类别
			sd_class_sug5 = sug[5].getSd_class_sug();
		}
				
		if(sug.length>6){
			sd_sug6=sug[6].getSd_sug();
			
			if(sug[6].getDt_start_sug()!= null){
				t.setSsjczrq7(sug[6].getDt_start_sug().toString(TimeZone.getDefault(), format2));
			}
			
			// 手术级别 
			sd_sug6_level=sug[6].getSd_lvlsug();				

			t.setSsjczmc7(sug[6].getName_sug());	
			t.setSz7(sug[6].getName_emp_sug());
			t.setYz7(sug[6].getName_emp_asst1());
			t.setEz7(sug[6].getName_emp_asst2());
			
			// 切口等级
			sd_incision6_level=sug[6].getSd_incitp();
			
			// 愈合类别
			sd_heal6_category=sug[6].getSd_incicondi();
						
			//麻醉方式
			sd_anaesthesia6_mode=sug[6].getSd_anestp();
			
			t.setMzys7(sug[6].getName_emp_anes());
			
			// 手术类别
			sd_class_sug6 = sug[6].getSd_class_sug();
		}
		
		if(sug.length>7){
sd_sug6=sug[6].getSd_sug();
			
			if(sug[6].getDt_start_sug()!= null){
				t.setSsjczrq7(sug[6].getDt_start_sug().toString(TimeZone.getDefault(), format2));
			}
			
			// 手术级别 
			sd_sug6_level=sug[7].getSd_lvlsug();				

			t.setSsjczmc8(sug[7].getName_sug());	
			t.setSz8(sug[7].getName_emp_sug());
			t.setYz8(sug[7].getName_emp_asst1());
			t.setEz8(sug[7].getName_emp_asst2());
			
			// 切口等级
			sd_incision7_level=sug[7].getSd_incitp();
			
			// 愈合类别
			sd_heal7_category=sug[7].getSd_incicondi();
						
			//麻醉方式
			sd_anaesthesia7_mode=sug[7].getSd_anestp();
			
			t.setMzys8(sug[7].getName_emp_anes());
			
			// 手术类别
			sd_class_sug7 = sug[7].getSd_class_sug();
		}
		
		
		// 手术操作编码
		List<String> sugCode=new ArrayList<String>();
		sugCode.add(sd_sug);
		sugCode.add(sd_sug1);
		sugCode.add(sd_sug2);		
		sugCode.add(sd_sug3);
		sugCode.add(sd_sug4);
		sugCode.add(sd_sug5);
		sugCode.add(sd_sug6);
		sugCode.add(sd_sug7);
			
		List<ValueContrastDetailDO> list3= dataContrastClassify(sugCode,"sug_code");
		if(list3!=null && list3.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list3){
				if(!StringUtil.isEmptyWithTrim(sd_sug)&& sd_sug.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm1(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug1)&& sd_sug1.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm2(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug2)&& sd_sug2.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm3(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug3)&& sd_sug3.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm4(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug4)&& sd_sug4.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm5(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug5)&& sd_sug5.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm6(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug6)&& sd_sug6.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm7(valueDetailDo.getCode_goal());					
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug7)&& sd_sug7.equals(valueDetailDo.getCode_source())){
					 t.setSsjczbm8(valueDetailDo.getCode_goal());					
				}
			}
		}
		if(!StringUtil.isEmptyWithTrim(sd_sug) && StringUtil.isEmptyWithTrim(t.getSsjczbm1())){
			t.setSsjczbm1(sd_sug);
			name_NoContrast+=" 手术及操作编码1—"+sd_sug;
		}			
		if(!StringUtil.isEmptyWithTrim(sd_sug1) && StringUtil.isEmptyWithTrim(t.getSsjczbm2())){
			t.setSsjczbm2(sd_sug1);
			name_NoContrast+=" 手术及操作编码2—"+sd_sug1;
		}
		if(!StringUtil.isEmptyWithTrim(sd_sug2) && StringUtil.isEmptyWithTrim(t.getSsjczbm3())){
			t.setSsjczbm3(sd_sug2);
			name_NoContrast+=" 手术及操作编码3—"+sd_sug2;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug3) && StringUtil.isEmptyWithTrim(t.getSsjczbm4())){
			t.setSsjczbm4(sd_sug3);
			name_NoContrast+=" 手术及操作编码4—"+sd_sug3;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug4) && StringUtil.isEmptyWithTrim(t.getSsjczbm5())){
			t.setSsjczbm5(sd_sug4);
			name_NoContrast+=" 手术及操作编码5—"+sd_sug4;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug5) && StringUtil.isEmptyWithTrim(t.getSsjczbm6())){
			t.setSsjczbm6(sd_sug5);
			name_NoContrast+=" 手术及操作编码6—"+sd_sug5;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug6) && StringUtil.isEmptyWithTrim(t.getSsjczbm7())){
			t.setSsjczbm7(sd_sug6);
			name_NoContrast+=" 手术及操作编码7—"+sd_sug6;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug7) && StringUtil.isEmptyWithTrim(t.getSsjczbm8())){
			t.setSsjczbm8(sd_sug7);
			name_NoContrast+=" 手术及操作编码8—"+sd_sug7;
		}	
		
		// 手术级别
		List<String> sugLevel=new ArrayList<String>();
		sugLevel.add(sd_sug_level);
		sugLevel.add(sd_sug1_level);
		sugLevel.add(sd_sug2_level);		
		sugLevel.add(sd_sug3_level);
		sugLevel.add(sd_sug4_level);
		sugLevel.add(sd_sug5_level);
		sugLevel.add(sd_sug6_level);
		sugLevel.add(sd_sug7_level);
		
		List<ValueContrastDetailDO> list4= dataContrastClassify(sugLevel,"sug_level");
		if(list4!=null && list4.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list4){
				if(!StringUtil.isEmptyWithTrim(sd_sug_level)&& sd_sug_level.equals(valueDetailDo.getCode_source())){
					 t.setShjb1(valueDetailDo.getCode_goal());
					 t.setSsjb1(valueDetailDo.getCode_goal());			
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug1_level)&& sd_sug1_level.equals(valueDetailDo.getCode_source())){
					 t.setShjb2(valueDetailDo.getCode_goal());
					 t.setSsjb2(valueDetailDo.getCode_goal());				
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug2_level)&& sd_sug2_level.equals(valueDetailDo.getCode_source())){
					 t.setShjb3(valueDetailDo.getCode_goal());
					 t.setSsjb3(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug3_level)&& sd_sug3_level.equals(valueDetailDo.getCode_source())){
					 t.setShjb4(valueDetailDo.getCode_goal());
					 t.setSsjb4(valueDetailDo.getCode_goal());							
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug4_level)&& sd_sug4_level.equals(valueDetailDo.getCode_source())){
					 t.setShjb5(valueDetailDo.getCode_goal());
					 t.setSsjb5(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug5_level)&& sd_sug5_level.equals(valueDetailDo.getCode_source())){
					 t.setShjb6(valueDetailDo.getCode_goal());
					 t.setSsjb6(valueDetailDo.getCode_goal());					
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug6_level)&& sd_sug6_level.equals(valueDetailDo.getCode_source())){	
					 t.setSsjb7(valueDetailDo.getCode_goal());	
				}
				if(!StringUtil.isEmptyWithTrim(sd_sug7_level)&& sd_sug7_level.equals(valueDetailDo.getCode_source())){	
					 t.setSsjb8(valueDetailDo.getCode_goal());	
				}
			}
		}
		if(!StringUtil.isEmptyWithTrim(sd_sug_level) && StringUtil.isEmptyWithTrim(t.getSsjb1())){
			 t.setShjb1(sd_sug_level);
			 t.setSsjb1(sd_sug_level);		
			name_NoContrast+=" 手术级别1—"+sd_sug_level;
		}			
		if(!StringUtil.isEmptyWithTrim(sd_sug1_level) && StringUtil.isEmptyWithTrim(t.getSsjb2())){
			 t.setShjb2(sd_sug1_level);
			 t.setSsjb2(sd_sug1_level);	
			name_NoContrast+=" 手术级别2—"+sd_sug1_level;
		}
		if(!StringUtil.isEmptyWithTrim(sd_sug2_level) && StringUtil.isEmptyWithTrim(t.getSsjb3())){
			 t.setShjb3(sd_sug2_level);
			 t.setSsjb3(sd_sug2_level);	
			name_NoContrast+=" 手术级别3—"+sd_sug2_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug3_level) && StringUtil.isEmptyWithTrim(t.getSsjb4())){
			 t.setShjb4(sd_sug3_level);
			 t.setSsjb4(sd_sug3_level);	
			name_NoContrast+=" 手术级别4—"+sd_sug3_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug4_level) && StringUtil.isEmptyWithTrim(t.getSsjb5())){
			 t.setShjb5(sd_sug4_level);
			 t.setSsjb5(sd_sug4_level);	
			name_NoContrast+=" 手术级别5—"+sd_sug4_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug5_level) && StringUtil.isEmptyWithTrim(t.getSsjb6())){
			 t.setShjb6(sd_sug5_level);
			 t.setSsjb6(sd_sug5_level);	
			name_NoContrast+=" 手术级别6—"+sd_sug5_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_sug6_level) && StringUtil.isEmptyWithTrim(t.getSsjb7())){
			t.setSsjb7(sd_sug6_level);
			name_NoContrast+=" 手术级别7—"+sd_sug6_level;
		}
		if(!StringUtil.isEmptyWithTrim(sd_sug7_level) && StringUtil.isEmptyWithTrim(t.getSsjb8())){
			t.setSsjb8(sd_sug7_level);
			name_NoContrast+=" 手术级别8—"+sd_sug7_level;
		}
		
			
		// 切口等级
		List<String> incisionLevel=new ArrayList<String>();
		incisionLevel.add(sd_incision_level);
		incisionLevel.add(sd_incision1_level);
		incisionLevel.add(sd_incision2_level);		
		incisionLevel.add(sd_incision3_level);
		incisionLevel.add(sd_incision4_level);
		incisionLevel.add(sd_incision5_level);
		incisionLevel.add(sd_incision6_level);
		incisionLevel.add(sd_incision7_level);
		
		List<ValueContrastDetailDO> list5= dataContrastClassify(sugLevel,"incision_level");
		if(list5!=null && list5.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list5){
				if(!StringUtil.isEmptyWithTrim(sd_incision_level)&& sd_incision_level.equals(valueDetailDo.getCode_source())){
					 t.setQkdj1(valueDetailDo.getCode_goal());		
				}
				if(!StringUtil.isEmptyWithTrim(sd_incision1_level)&& sd_incision1_level.equals(valueDetailDo.getCode_source())){
					 t.setQkdj2(valueDetailDo.getCode_goal());			
				}
				if(!StringUtil.isEmptyWithTrim(sd_incision2_level)&& sd_incision2_level.equals(valueDetailDo.getCode_source())){
					 t.setQkdj3(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_incision3_level)&& sd_incision3_level.equals(valueDetailDo.getCode_source())){
					 t.setQkdj4(valueDetailDo.getCode_goal());							
				}
				if(!StringUtil.isEmptyWithTrim(sd_incision4_level)&& sd_incision4_level.equals(valueDetailDo.getCode_source())){
					 t.setQkdj5(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_incision5_level)&& sd_incision5_level.equals(valueDetailDo.getCode_source())){
					 t.setQkdj6(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_incision6_level)&& sd_incision6_level.equals(valueDetailDo.getCode_source())){	
					 t.setQkdj7(valueDetailDo.getCode_goal());	
				}
				if(!StringUtil.isEmptyWithTrim(sd_incision7_level)&& sd_incision7_level.equals(valueDetailDo.getCode_source())){	
					 t.setQkdj8(valueDetailDo.getCode_goal());	
				}
			}
		}
		if(!StringUtil.isEmptyWithTrim(sd_incision_level) && StringUtil.isEmptyWithTrim(t.getQkdj1())){
			t.setQkdj1(sd_incision_level);
			name_NoContrast+=" 切口等级1—"+sd_incision_level;
		}			
		if(!StringUtil.isEmptyWithTrim(sd_incision1_level) && StringUtil.isEmptyWithTrim(t.getQkdj2())){
			t.setQkdj2(sd_incision1_level);
			name_NoContrast+=" 切口等级2—"+sd_incision1_level;
		}
		if(!StringUtil.isEmptyWithTrim(sd_incision2_level) && StringUtil.isEmptyWithTrim(t.getQkdj3())){
			t.setQkdj3(sd_incision2_level);
			name_NoContrast+=" 切口等级3—"+sd_incision2_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_incision3_level) && StringUtil.isEmptyWithTrim(t.getQkdj4())){
			t.setQkdj4(sd_incision3_level);
			name_NoContrast+=" 切口等级4—"+sd_incision3_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_incision4_level) && StringUtil.isEmptyWithTrim(t.getQkdj5())){
			t.setQkdj5(sd_incision4_level);
			name_NoContrast+=" 切口等级5—"+sd_incision4_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_incision5_level) && StringUtil.isEmptyWithTrim(t.getQkdj6())){
			t.setQkdj6(sd_incision5_level);
			name_NoContrast+=" 切口等级6—"+sd_incision5_level;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_incision6_level) && StringUtil.isEmptyWithTrim(t.getQkdj7())){
			t.setQkdj7(sd_incision6_level);
			name_NoContrast+=" 切口等级7—"+sd_incision6_level;
		}
		if(!StringUtil.isEmptyWithTrim(sd_incision7_level) && StringUtil.isEmptyWithTrim(t.getQkdj8())){
			t.setQkdj8(sd_incision7_level);
			name_NoContrast+=" 切口等级8—"+sd_incision7_level;
		}
				
		
		// 愈合类别
		List<String> healCategory=new ArrayList<String>();
		healCategory.add(sd_heal_category);
		healCategory.add(sd_heal1_category);
		healCategory.add(sd_heal2_category);		
		healCategory.add(sd_heal3_category);
		healCategory.add(sd_heal4_category);
		healCategory.add(sd_heal5_category);
		healCategory.add(sd_heal6_category);
		healCategory.add(sd_heal7_category);
		
		List<ValueContrastDetailDO> list6= dataContrastClassify(healCategory,"heal_category");
		if(list6!=null && list6.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list6){
				if(!StringUtil.isEmptyWithTrim(sd_heal_category)&& sd_heal_category.equals(valueDetailDo.getCode_source())){
					 t.setQkyhlb1(valueDetailDo.getCode_goal());
					 t.setQkylb1(valueDetailDo.getCode_goal());	 
				}
				if(!StringUtil.isEmptyWithTrim(sd_heal1_category)&& sd_heal1_category.equals(valueDetailDo.getCode_source())){
					 t.setQkyhlb2(valueDetailDo.getCode_goal());
					 t.setQkylb2(valueDetailDo.getCode_goal());	 			
				}
				if(!StringUtil.isEmptyWithTrim(sd_heal2_category)&& sd_heal2_category.equals(valueDetailDo.getCode_source())){
					 t.setQkyhlb3(valueDetailDo.getCode_goal());
					 t.setQkylb3(valueDetailDo.getCode_goal());	 				
				}
				if(!StringUtil.isEmptyWithTrim(sd_heal3_category)&& sd_heal3_category.equals(valueDetailDo.getCode_source())){
					 t.setQkyhlb4(valueDetailDo.getCode_goal());
					 t.setQkylb4(valueDetailDo.getCode_goal());	 					
				}
				if(!StringUtil.isEmptyWithTrim(sd_heal4_category)&& sd_heal4_category.equals(valueDetailDo.getCode_source())){
					 t.setQkyhlb5(valueDetailDo.getCode_goal());
					 t.setQkylb5(valueDetailDo.getCode_goal());						
				}
				if(!StringUtil.isEmptyWithTrim(sd_heal5_category)&& sd_heal5_category.equals(valueDetailDo.getCode_source())){
					 t.setQkyhlb6(valueDetailDo.getCode_goal());
					 t.setQkylb6(valueDetailDo.getCode_goal());	 				
				}
				if(!StringUtil.isEmptyWithTrim(sd_heal6_category)&& sd_heal6_category.equals(valueDetailDo.getCode_source())){	
					 t.setQkyhlb7(valueDetailDo.getCode_goal());				
				}
				if(!StringUtil.isEmptyWithTrim(sd_heal7_category)&& sd_heal7_category.equals(valueDetailDo.getCode_source())){	
					 t.setQkyhlb8(valueDetailDo.getCode_goal());				
				}
			}
		}
		
		if(!StringUtil.isEmptyWithTrim(sd_heal_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb1())){
			t.setQkyhlb1(sd_heal_category);
			t.setQkylb1(sd_heal_category);	 
			name_NoContrast+=" 切口愈合类别1—"+sd_heal_category;
		}			
		if(!StringUtil.isEmptyWithTrim(sd_heal1_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb2())){
			t.setQkyhlb2(sd_heal1_category);
			t.setQkylb2(sd_heal1_category);	 
			name_NoContrast+=" 切口愈合类别2—"+sd_heal1_category;
		}
		if(!StringUtil.isEmptyWithTrim(sd_heal2_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb3())){
			t.setQkyhlb3(sd_heal2_category);
			t.setQkylb3(sd_heal2_category);
			name_NoContrast+=" 切口愈合类别3—"+sd_heal2_category;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_heal3_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb4())){
			t.setQkyhlb4(sd_heal3_category);
			t.setQkylb4(sd_heal3_category);	 	
			name_NoContrast+=" 切口愈合类别4—"+sd_heal3_category;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_heal4_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb5())){
			t.setQkyhlb5(sd_heal4_category);
			t.setQkylb5(sd_heal4_category);		
			name_NoContrast+=" 切口愈合类别5—"+sd_heal4_category;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_heal5_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb6())){
			t.setQkyhlb6(sd_heal5_category);
			t.setQkylb6(sd_heal5_category);	 	
			name_NoContrast+=" 切口愈合类别6—"+sd_heal5_category;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_heal6_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb7())){
			t.setQkyhlb7(sd_heal6_category);
			name_NoContrast+=" 切口愈合类别7—"+sd_heal6_category;
		}
		if(!StringUtil.isEmptyWithTrim(sd_heal7_category) && StringUtil.isEmptyWithTrim(t.getQkyhlb8())){
			t.setQkyhlb8(sd_heal7_category);
			name_NoContrast+=" 切口愈合类别8—"+sd_heal7_category;
		}
		
				
		// 麻醉方式 
		List<String> anaesthesiaMode=new ArrayList<String>();
		anaesthesiaMode.add(sd_anaesthesia_mode);
		anaesthesiaMode.add(sd_anaesthesia1_mode);
		anaesthesiaMode.add(sd_anaesthesia2_mode);		
		anaesthesiaMode.add(sd_anaesthesia3_mode);
		anaesthesiaMode.add(sd_anaesthesia4_mode);
		anaesthesiaMode.add(sd_anaesthesia5_mode);
		anaesthesiaMode.add(sd_anaesthesia6_mode);
		anaesthesiaMode.add(sd_anaesthesia7_mode);
		
		List<ValueContrastDetailDO> list7= dataContrastClassify(anaesthesiaMode,"anaesthesia_mode");
		if(list7!=null && list7.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list7){
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia_mode)&& sd_anaesthesia_mode.equals(valueDetailDo.getCode_source())){
					 t.setMzfs1(valueDetailDo.getCode_goal());	 
				}
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia1_mode)&& sd_anaesthesia1_mode.equals(valueDetailDo.getCode_source())){
					 t.setMzfs2(valueDetailDo.getCode_goal());			
				}
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia2_mode)&& sd_anaesthesia2_mode.equals(valueDetailDo.getCode_source())){
					 t.setMzfs3(valueDetailDo.getCode_goal());		
				}
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia3_mode)&& sd_anaesthesia3_mode.equals(valueDetailDo.getCode_source())){
					 t.setMzfs4(valueDetailDo.getCode_goal());				
				}
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia4_mode)&& sd_anaesthesia4_mode.equals(valueDetailDo.getCode_source())){
					 t.setMzfs5(valueDetailDo.getCode_goal());					
				}
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia5_mode)&& sd_anaesthesia5_mode.equals(valueDetailDo.getCode_source())){
					 t.setMzfs6(valueDetailDo.getCode_goal());			
				}
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia6_mode)&& sd_anaesthesia6_mode.equals(valueDetailDo.getCode_source())){	
					 t.setMzfs7(valueDetailDo.getCode_goal());			
				}
				if(!StringUtil.isEmptyWithTrim(sd_anaesthesia7_mode)&& sd_anaesthesia7_mode.equals(valueDetailDo.getCode_source())){	
					 t.setMzfs8(valueDetailDo.getCode_goal());			
				}
			}
		}
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia_mode) && StringUtil.isEmptyWithTrim(t.getMzfs1())){
			t.setMzfs1(sd_anaesthesia_mode);
			name_NoContrast+=" 麻醉方式1—"+sd_anaesthesia_mode;
		}			
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia1_mode) && StringUtil.isEmptyWithTrim(t.getMzfs2())){
			t.setMzfs2(sd_anaesthesia1_mode);
			name_NoContrast+=" 麻醉方式2—"+sd_anaesthesia1_mode;
		}
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia2_mode) && StringUtil.isEmptyWithTrim(t.getMzfs3())){
			t.setMzfs3(sd_anaesthesia2_mode);
			name_NoContrast+=" 麻醉方式3—"+sd_anaesthesia2_mode;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia3_mode) && StringUtil.isEmptyWithTrim(t.getMzfs4())){
			t.setMzfs4(sd_anaesthesia3_mode);
			name_NoContrast+=" 麻醉方式4—"+sd_anaesthesia3_mode;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia4_mode) && StringUtil.isEmptyWithTrim(t.getMzfs5())){
			t.setMzfs5(sd_anaesthesia4_mode);
			name_NoContrast+=" 麻醉方式5—"+sd_anaesthesia4_mode;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia5_mode) && StringUtil.isEmptyWithTrim(t.getMzfs6())){
			t.setMzfs6(sd_anaesthesia5_mode);
			name_NoContrast+=" 麻醉方式6—"+sd_anaesthesia5_mode;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia6_mode) && StringUtil.isEmptyWithTrim(t.getMzfs7())){
			t.setMzfs7(sd_anaesthesia6_mode);
			name_NoContrast+=" 麻醉方式7—"+sd_anaesthesia6_mode;
		}
		if(!StringUtil.isEmptyWithTrim(sd_anaesthesia7_mode) && StringUtil.isEmptyWithTrim(t.getMzfs8())){
			t.setMzfs8(sd_anaesthesia7_mode);
			name_NoContrast+=" 麻醉方式8—"+sd_anaesthesia7_mode;
		}
		
		//手术类别
		List<String>ClassSug = new ArrayList<String>();
		ClassSug.add(sd_class_sug);
		ClassSug.add(sd_class_sug1);
		ClassSug.add(sd_class_sug2);
		ClassSug.add(sd_class_sug3);
		ClassSug.add(sd_class_sug4);
		ClassSug.add(sd_class_sug5);
		ClassSug.add(sd_class_sug6);
		ClassSug.add(sd_class_sug7);
		List<ValueContrastDetailDO> list8= dataContrastClassify(ClassSug,"class_sug");
		if(list8!=null && list8.size()>0){
			for(ValueContrastDetailDO valueDetailDo: list8){
				if(!StringUtil.isEmptyWithTrim(sd_class_sug)&& sd_class_sug.equals(valueDetailDo.getCode_source())){
					 t.setSslx1(valueDetailDo.getCode_goal());
				}
				if(!StringUtil.isEmptyWithTrim(sd_class_sug1)&& sd_class_sug1.equals(valueDetailDo.getCode_source())){
					 t.setSslx2(valueDetailDo.getCode_goal());		
				}
				if(!StringUtil.isEmptyWithTrim(sd_class_sug2)&& sd_class_sug2.equals(valueDetailDo.getCode_source())){
					 t.setSslx3(valueDetailDo.getCode_goal());		
				}
				if(!StringUtil.isEmptyWithTrim(sd_class_sug3)&& sd_class_sug3.equals(valueDetailDo.getCode_source())){
					 t.setSslx4(valueDetailDo.getCode_goal());				
				}
				if(!StringUtil.isEmptyWithTrim(sd_class_sug4)&& sd_class_sug4.equals(valueDetailDo.getCode_source())){
					 t.setSslx5(valueDetailDo.getCode_goal());					
				}
				if(!StringUtil.isEmptyWithTrim(sd_class_sug5)&& sd_class_sug5.equals(valueDetailDo.getCode_source())){
					 t.setSslx6(valueDetailDo.getCode_goal());			
				}
				if(!StringUtil.isEmptyWithTrim(sd_class_sug6)&& sd_class_sug6.equals(valueDetailDo.getCode_source())){	
					 t.setSslx7(valueDetailDo.getCode_goal());			
				}
				if(!StringUtil.isEmptyWithTrim(sd_class_sug7)&& sd_class_sug7.equals(valueDetailDo.getCode_source())){	
					 t.setSslx8(valueDetailDo.getCode_goal());			
				}
			}
		}
		
		if(!StringUtil.isEmptyWithTrim(sd_class_sug) && StringUtil.isEmptyWithTrim(t.getSslx1())){
			t.setSslx1(sd_class_sug);
			name_NoContrast+=" 手术类型1—"+sd_class_sug;
		}			
		if(!StringUtil.isEmptyWithTrim(sd_class_sug1) && StringUtil.isEmptyWithTrim(t.getSslx2())){
			t.setSslx2(sd_class_sug1);
			name_NoContrast+=" 手术类型2—"+sd_class_sug1;
		}
		if(!StringUtil.isEmptyWithTrim(sd_class_sug2) && StringUtil.isEmptyWithTrim(t.getSslx3())){
			t.setSslx3(sd_class_sug2);
			name_NoContrast+=" 手术类型3—"+sd_class_sug2;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_class_sug3) && StringUtil.isEmptyWithTrim(t.getSslx4())){
			t.setSslx4(sd_class_sug3);
			name_NoContrast+=" 手术类型4—"+sd_class_sug3;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_class_sug4) && StringUtil.isEmptyWithTrim(t.getSslx5())){
			t.setSslx5(sd_class_sug4);
			name_NoContrast+=" 手术类型5—"+sd_class_sug4;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_class_sug5) && StringUtil.isEmptyWithTrim(t.getSslx6())){
			t.setSslx6(sd_class_sug5);
			name_NoContrast+=" 手术类型6—"+sd_class_sug5;
		}	
		if(!StringUtil.isEmptyWithTrim(sd_class_sug6) && StringUtil.isEmptyWithTrim(t.getSslx7())){
			t.setSslx7(sd_class_sug6);
			name_NoContrast+=" 手术类型7—"+sd_class_sug6;
		}
		if(!StringUtil.isEmptyWithTrim(sd_class_sug7) && StringUtil.isEmptyWithTrim(t.getSslx8())){
			t.setSslx8(sd_class_sug7);
			name_NoContrast+=" 手术类型8—"+sd_class_sug7;
		}
		
		//ICD编码
		String icdo = "";
		if(c.getCode_icdo3() != null && !"".equals(c.getCode_icdo3())){
			icdo = c.getCode_icdo3();
		}
		List<String>ICDO = new ArrayList<String>();
		ICDO.add(icdo);
		List<ValueContrastDetailDO> list9= dataContrastClassify(ICDO,"icdo");
		if(list9 != null && list9.size()>0){
			t.setIcdo3(list9.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(icdo)){
				t.setIcdo3(icdo);
				name_NoContrast+=" ICD编码-"+icdo;
			}
		}
		
		//最高诊断依据
		String zgzdyj = "";
		if(c.getSd_hightestdi() != null && !"".equals(c.getSd_hightestdi())){
			zgzdyj = c.getSd_hightestdi();
		}
		List<String>hightestdi = new ArrayList<String>();
		hightestdi.add(zgzdyj);
		List<ValueContrastDetailDO> list10= dataContrastClassify(hightestdi,"sd_hightestdi");
		if(list10 != null && list10.size()>0){
			t.setZgzdyj(list10.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(zgzdyj)){
				t.setZgzdyj(zgzdyj);
				name_NoContrast+=" 最高诊断依据—"+zgzdyj;
			}
		}
		
		//入径情况
		String rjqk = "";
		if(c.getSd_inpathstatus() != null && !"".equals(c.getSd_inpathstatus())){
			rjqk = c.getSd_inpathstatus();
		}
		List<String>inpathstatus = new ArrayList<String>();
		inpathstatus.add(rjqk);
		List<ValueContrastDetailDO> list11= dataContrastClassify(inpathstatus,"sd_inpathstatus");
		if(list11 != null && list11.size()>0){
			t.setRjqk(list11.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(rjqk)){
				t.setRjqk(rjqk);
				name_NoContrast+=" 入径情况—"+rjqk;
			}
		}
		
		//完成情况
		String wcqk = "";
		if(c.getSd_completestatus() != null && !"".equals(c.getSd_completestatus())){
			wcqk = c.getSd_completestatus();
		}
		List<String>completestatus = new ArrayList<String>();
		completestatus.add(wcqk);
		List<ValueContrastDetailDO> list12= dataContrastClassify(completestatus,"sd_completestatus");
		if(list12 != null && list12.size()>0){
			t.setWcqk(list12.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(wcqk)){
				t.setWcqk(wcqk);
				name_NoContrast+=" 完成情况—"+wcqk;
			}
		}
		
		//变异情况
		String byqk = "";
		if(c.getSd_variationstaus() != null && !"".equals(c.getSd_variationstaus())){
			byqk = c.getSd_variationstaus();
		}
		List<String>variationstaus = new ArrayList<String>();
		variationstaus.add(byqk);
		List<ValueContrastDetailDO> list13= dataContrastClassify(variationstaus,"sd_variationstaus");
		if(list13 != null && list13.size()>0){
			t.setByqk(list13.get(0).getCode_goal());
		}else{
			if(!StringUtil.isEmptyWithTrim(byqk)){
				t.setByqk(byqk);
				name_NoContrast+=" 变异情况—"+byqk;
			}
		}
		
		t.setYzzy_jgmc(c.getName_med_in_1());
		t.setYzzy_yljg(t.getYzzy_jgmc());
		t.setWsy_jgmc(c.getName_med_in_2());
		t.setWsy_yljg(t.getWsy_jgmc());
		t.setZzyjh(c.getId_is_have_inhos_plan());
		t.setSfzzyjh(t.getZzyjh());
		t.setMd(c.getGoal_inhos_plan());
		
		t.setRyq_t(c.getComa_time_bef_inhos_days() == null ? "0" : c.getComa_time_bef_inhos_days().toString());
		t.setRyq_xs( c.getComa_time_bef_inhos_hours()==null ? "0" :c.getComa_time_bef_inhos_hours().toString());
		t.setRyq_fz(c.getComa_time_bef_inhos_mins() == null ? "0" : c.getComa_time_bef_inhos_mins().toString());
		t.setRyh_f(t.getRyq_fz());
		t.setRyh_t(c.getComa_time_inhos_days() == null ? "0" : c.getComa_time_inhos_days().toString());
		t.setRyh_xs(c.getComa_time_inhos_hours() == null ? "0" : c.getComa_time_inhos_hours().toString());
		t.setRyh_fz(c.getComa_time_inhos_mins() == null ? "0" : c.getComa_time_inhos_mins().toString());
		
		t.setZfy(c.getAmount() == null ? null :c.getAmount().toString());
		t.setZfje(c.getCms_spamount() == null ? null : c.getCms_spamount().toString());
		t.setYlfwf(c.getCms_gmsfee()==null?null:c.getCms_gmsfee().toString() );
		t.setYlfuf(t.getYlfwf());
		t.setBzlzf(c.getCms_decnfee()==null?null:c.getCms_decnfee().toString());
		t.setZyblzhzf(c.getCms_decfee()==null?null:c.getCms_decfee().toString());
		t.setZlczf(c.getCms_gtofee()==null?null:c.getCms_gtofee().toString());
		t.setHlf(c.getCms_nurfee()==null?null:c.getCms_nurfee().toString());
		t.setQtfy(c.getCms_otherfee()==null?null:c.getCms_otherfee().toString());
		t.setBlzdf(c.getDi_pdifee()==null?null:c.getDi_pdifee().toString());
		t.setKff(c.getRc_rcfee()==null?null:c.getRc_rcfee().toString());
		
		t.setZdf(c.getDi_ldifee()==null?null:c.getDi_ldifee().toString());
		t.setSyszdf(t.getZdf());
		t.setYxxzdf(c.getDi_idifee()==null?null:c.getDi_idifee().toString());
		t.setLczdxmf(c.getDi_cdifee()==null?null:c.getDi_cdifee().toString());
		t.setFsszlxmf(c.getTc_nstpfee()==null?null:c.getTc_nstpfee().toString());
		t.setZlf(c.getTc_cptfee()==null?null:c.getTc_cptfee().toString());
		t.setWlzlf(t.getZlf());
		t.setSszlf(c.getTc_stfee()==null?null:c.getTc_stfee().toString());
		t.setMzf(c.getTc_anfee()==null?null:c.getTc_anfee().toString());
		t.setMaf(t.getMzf());
		t.setSsf(c.getTc_opfee()==null?null:c.getTc_opfee().toString());
		t.setZyl_zyzd(c.getTcm_difee()==null?null:c.getTcm_difee().toString());
		
		t.setZyzl(c.getTcm_cmtfee()==null?null:c.getTcm_cmtfee().toString());
		t.setZyzlf(t.getZyzl());
		t.setZywz(c.getTcm_etfee()==null?null:c.getTcm_etfee().toString());
		t.setZygs(c.getTcm_bffee()==null?null:c.getTcm_bffee().toString());
		t.setZcyjf(c.getTcm_tcmfee()==null?null:c.getTcm_tcmfee().toString());
		t.setZytnzl(c.getTcm_mnpfee()==null?null:c.getTcm_mnpfee().toString());
		t.setZygczl(c.getTcm_anrfee()==null?null:c.getTcm_anrfee().toString());
		t.setZytszl(c.getTcm_spcialfee()==null?null:c.getTcm_spcialfee().toString());
		t.setZyqt(c.getTcm_otherfee()==null?null:c.getTcm_otherfee().toString());
		t.setZytstpjg(c.getTcm_allocationfee()==null?null:c.getTcm_allocationfee().toString());
		t.setBzss(c.getTcm_dcfee()==null?null:c.getTcm_dcfee().toString());
		t.setXyf(c.getWm_wmfee()==null?null:c.getWm_wmfee().toString());
		t.setKjywf(c.getWm_agfee()==null?null:c.getWm_agfee().toString());
		t.setZcyf(c.getTcmt_cpmfee()==null?null:c.getTcmt_cpmfee().toString());
		t.setZyzjf(c.getTcmt_ppafee()==null?null:c.getTcmt_ppafee().toString());//医疗机构中药制剂费
		t.setZcyf1(c.getTcmt_chmfee()==null?null:c.getTcmt_chmfee().toString());
		t.setXf(c.getBabp_bfee()==null?null:c.getBabp_bfee().toString());
		t.setBdblzpf(c.getBabp_apfee()==null?null:c.getBabp_apfee().toString());
		t.setQdblzpf(c.getBabp_gpfee()==null?null:c.getBabp_gpfee().toString());
		t.setNxyzlzpf(c.getBabp_bcffee()==null?null:c.getBabp_bcffee().toString());
		t.setXbyzlzpf(c.getBabp_cflfee()==null?null:c.getBabp_cflfee().toString());
		t.setJcyyclf(c.getSc_dmmfifee()==null?null:c.getSc_dmmfifee().toString());
		t.setHcyyclf(t.getJcyyclf());
		t.setYyclf(c.getSc_dmmftfee()==null?null:c.getSc_dmmftfee().toString());
		//t.setHcyyclf(t.getYyclf());
		t.setSsycxclf(c.getSc_dmmfsfee()==null?null:c.getSc_dmmfsfee().toString());
		t.setYcxyyclf(t.getSsycxclf());
		t.setQtf(c.getOc_ocfee()==null?null:c.getOc_ocfee().toString());
		t.setMsg(name_NoContrast);
			lists.add(t);	
		}	  
		return lists;
	}
	/**
	 * 疾病编码转化
	 * @param sd_di
	 * @return
	 *//*
	private String sd_diConvert(String sd_di)
	{
		String newSd_di = null;
		if(sd_di!=null)
		{
			int len = sd_di.length();
			newSd_di = sd_di.substring(0, len<7?len:7);
		}
		return newSd_di;
	}*/
	
	
	/**
	 * 科室对照分类
	 * @throws DAException 
	 */
	private List<ValueContrastDetailDO> contrastClassify(CiMrFpDTO c) throws BizException{
		
		// 入院科别
 		String rykb=c.getSd_dep_phyadm();
		// 转科科别
		String zkkb=c.getSd_dep_trans();
		// 出院科别
		String cykb=c.getSd_dep_phydisc();
		
		DAFacade daf = new DAFacade();   
 		StringBuilder sb=new StringBuilder();
 		SqlParam sp=new SqlParam();
 		
 		// 卫统4对照编码
 		String code="cs001";
 		// 科室编码 
 		String dep="bd_dep";
 		
		sb.append(" select  *  ");
		sb.append(" from ci_mrm_value_contrast_detail cd ");
		sb.append(" left join ci_mrm_value_contrast cvc ");
		sb.append(" on cd.id_value_comparison=cvc.id_value_comparison ");
		sb.append(" left join ci_mrm_con_classify cc ");
		sb.append(" on cc.id_comparison=cvc.id_comparison ");
		sb.append(" where cc.code='"+code+"' and cvc.comparison_code_source='"+dep+"' ");
 		sb.append(" and cd.code_source in (?,?,?) ");
 		
		sp.addParam(rykb);  sp.addParam(zkkb);  sp.addParam(cykb);
		
		@SuppressWarnings("unchecked")
		List<ValueContrastDetailDO> list = (List<ValueContrastDetailDO>) daf.execQuery(sb.toString(), sp, new BeanListHandler(ValueContrastDetailDO.class));
		return list;
	}

	/**
	 * 对照分类
	 * @throws DAException 
	 */
	private List<ValueContrastDetailDO> dataContrastClassify(List<String> list,String contrastcode) throws BizException{
	
		// 卫统4对照编码
 		String code="cs001";
 	
		DAFacade daf = new DAFacade();   
 		StringBuilder sb=new StringBuilder();
 	
 		String inwhere="";
 		for(int i=0;i<list.size();i++){
 			if(i==list.size()-1){
 				inwhere +="'"+list.get(i)+"')";
 			}else{
 				inwhere +="'"+list.get(i)+"',";
 			}	
 		}

		sb.append(" select  *  ");
		sb.append(" from ci_mrm_value_contrast_detail cd ");
		sb.append(" left join ci_mrm_value_contrast cvc ");
		sb.append(" on cd.id_value_comparison=cvc.id_value_comparison ");
		sb.append(" left join ci_mrm_con_classify cc ");
		sb.append(" on cc.id_comparison=cvc.id_comparison ");
		sb.append(" where cc.code='"+code+"' and cvc.comparison_code_source='"+contrastcode+"'");
 		sb.append(" and cd.code_source in ( ");
 		sb.append(inwhere);
		
		@SuppressWarnings("unchecked")
		List<ValueContrastDetailDO> listData = (List<ValueContrastDetailDO>) daf.execQuery(sb.toString(), new BeanListHandler(ValueContrastDetailDO.class));
		return listData;
	}
	
	
	
	/**
	 * 获取源数据
	 */
	public List<CiMrmDirHeaReportDTO> getDatas(QryRootNodeDTO qryRootNodeDTO,String sqlWhere) throws BizException
	{
		//IBlstipRService Iblcgquery = ServiceFinder.find(IBlstipRService.class);
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		//上报数据来源
		String Name_src ="";
		int result = CiMrMParamUtils.GetSysParamCIMRFP_REPORT_DATA_SRC(Context.get().getOrgId());
		switch(result)
		{		
		case 2://编目获取
			
			Name_src= "ci_mr_fp_pat_cata";
			break;
		default://首页和编目（编目优先）、首页
			Name_src= "ci_mr_fp_pat";
			break;
		}
		StringBuilder sql = new StringBuilder();
		if(service.getQueryStringWithoutDesc(qryRootNodeDTO) != null ){
			
		
			sql.append("SELECT * FROM ( SELECT");
			sql.append(" EN_ENT.ID_ENT,ROWNUM RN ");
			sql.append(" FROM "+Name_src+" PAT ");
			sql.append("  LEFT JOIN EN_ENT ON EN_ENT.Id_Ent = PAT.Id_Ent "); 
			sql.append(" LEFT JOIN EN_ENT_IP ON EN_ENT.ID_ENT = EN_ENT_IP.ID_ENT");
			sql.append(" LEFT JOIN BD_DEP ON EN_ENT_IP.ID_DEP_PHYDISC = BD_DEP.ID_DEP");
			sql.append(" where EN_ENT.CODE_ENTP = '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"' ");
			sql.append(" and EN_ENT_IP.SD_STATUS = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"'");
			sql.append(" and "+service.getQueryStringWithoutDesc(qryRootNodeDTO)+") ");
			sql.append(" where "+sqlWhere);
		}
		DAFacade da = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> lstMrFpPat = (List<PatiVisitDO>)da.execQuery(sql.toString(),new BeanListHandler(PatiVisitDO.class));
		CiMrmGenerateListBp CiMrmGenList = new CiMrmGenerateListBp();
		String[] arrIdEnt = CiMrmGenList.getIdEntFromBlCgIp(lstMrFpPat);
		
		CiMrmGenerateCSVBp cimrmlist = new CiMrmGenerateCSVBp();
		List<CiMrmDirHeaReportDTO>lists = cimrmlist.getMrmDirHeaReportDTOList(arrIdEnt);
		return lists;
	}

	/**
	 * 获取列信息（名称和顺序）
	 * @return
	 */
	public String[] getHeaders()
	{
		int res = CiMrMParamUtils.GetSysParamMRM_FP_TYPE(Context.get().getOrgId());
		String[] fs={"username","ylfkfs","jkkh","zycs","bah","xm","xb","csrq","nl","gj","bzyzs_nl","xsetz",
	  			   "xserytz","csd","gg","mz","sfzh","zy","hy","xzz","dh","yb1","hkdz","yb2","gzdwjdz","dwdh",
	  			   "yb3","lxrxm","gx","dz","dh1","rytj","zllb","rysj","rysj_s","rykb","rybf","zkkb","cysj","cysj_s",
	  			   "cykb","cybf","sjzy","mzd_zyzd","jbdm","mzd_xyzd","jbbm","sslclj","zyyj","zyzlsb","zyzljs",
	  			   "bzsh","zb","zb_jbbm","zb_rybq","zyzd","zyzd_jbbm","xy_rybq","zz1","zz_jbbm1","zz_rybq1",
	  			   "qtzd1","zyzd_jbbm1","rybq1","zz2","zz_jbbm2","zz_rybq2","qtzd2","zyzd_jbbm2","rybq2","zz3",
	  			   "zz_jbbm3","zz_rybq3","qtzd3","zyzd_jbbm3","rybq3","zz4","zz_jbbm4","zz_rybq4","qtzd4",
	  			   "zyzd_jbbm4","rybq4","zz5","zz_jbbm5","zz_rybq5","qtzd5","zyzd_jbbm5","rybq5","zz6","zz_jbbm6",
	  			   "zz_rybq6","qtzd6","zyzd_jbbm6","rybq6","zz7","zz_jbbm7","zz_rybq7","qtzd7",
	  			   "zyzd_jbbm7","rybq7","wbyy","jbbm1","blzd","jbbm2","blh","ywgm","gmyw","sj","xx",
	  			   "rh","kzr","zrys","zzys","zyys","zrhs","jxys","sxys","bmy","bazl","zkys","zkhs","zkrq",
	  			   "ssjczbm1","ssjczrq1","shjb1","ssjczmc1","sz1","yz1","ez1","qkdj1","qkylb1","mzfs1","mzys1","ssjczbm2","ssjczrq2",
	  			   "shjb2","ssjczmc2","sz2","yz2","ez2","qkdj2","qkylb2","mzfs2","mzys2","ssjczbm3",
	  			   "ssjczrq3","shjb3","ssjczmc3","sz3","yz3","ez3","qkdj3","qkylb3","mzfs3","mzys3","ssjczbm4","ssjczrq4",
	  			   "shjb4","ssjczmc4","sz4","yz4","ez4","qkdj4","qkylb4","mzfs4","mzys4","ssjczbm5",
	  			   "ssjczrq5","shjb5","ssjczmc5","sz5","yz5","ez5","qkdj5","qkylb5","mzfs5","mzys5","ssjczbm6",
	  			   "ssjczrq6","shjb6","ssjczmc6","sz6","yz6","ez6","qkdj6","qkylb6","mzfs6","mzys6","lyfs",
	  			   "yzzy_jgmc","wsy_jgmc","zzyjh","md","ryq_t","ryq_xs","ryq_fz","ryh_t","ryh_xs","ryh_fz","zfy",
	  			 "zfje","ylfwf","bzlzf","zyblzhzf","zlczf","hlf","qtfy","blzdf","zdf","yxxzdf","lczdxmf","fsszlxmf","zlf",
				   "sszlf","mzf","ssf","kff","zyl_zyzd","zyzl","zywz","zygs","zcyjf","zytnzl","zygczl",
				   "zytszl","zyqt","zytstpjg","bzss","xyf","kjywf","zcyf","zyzjf","zcyf1","xf","bdblzpf","qdblzpf","nxyzlzpf",
				   "xbyzlzpf","jcyyclf","yyclf","ssycxclf","qtf"};
		if(res == 0)
		{
			 fs=new String[]{"username","ylfkfs","jkkh","zycs","bah","xm","xb","csrq","nl","gj","bzyzsnl","xsecstz","xserytz",
					 "csd","gg","mz","sfzh","zy","hy","xzz","dh","yb1","hkdz","yb2","gzdwjdz","dwdh","yb3","lxrxm","gx","dz",
					 "dh2","rytj","rysj","rysjs","rykb","rybf","zkkb","cysj","cysjs","cykb","cybf","sjzyts","mzzd","jbbm",
					 "zyzd","jbdm","rybq","qtzd8","jbdm8","rybq8","qtzd1","jbdm1","rybq1","qtzd9","jbdm9","rybq9","qtzd2",
					 "jbdm2","rybq2","qtzd10","jbdm10","rybq10","qtzd3","jbdm3","rybq3","qtzd11","jbdm11","rybq11","qtzd4",
					 "jbdm4","rybq4","qtzd12","jbdm12","rybq12","qtzd5","jbdm5","rybq5","qtzd13","jbdm13","rybq13","qtzd6",
					 "jbdm6","rybq6","qtzd14","jbdm14","rybq14","qtzd7","jbdm7","rybq7","qtzd15","jbdm15","rybq15","wbyy",
					 "h23","blzd","jbmm","blh","ywgm","gmyw","swhzsj","xx","rh","kzr","zrys","zzys","zyys","zrhs","jxys",
					 "sxys","bmy","bazl","zkys","zkhs","zkrq","ssjczbm1","ssjczrq1","ssjb1","ssjczmc1","sz1","yz1","ez1",
					 "qkdj1","qkyhlb1","mzfs1","mzys1","ssjczbm2","ssjczrq2","ssjb2","ssjczmc2","sz2","yz2","ez2","qkdj2",
					 "qkyhlb2","mzfs2","mzys2","ssjczbm3","ssjczrq3","ssjb3","ssjczmc3","sz3","yz3","ez3","qkdj3","qkyhlb3",
					 "mzfs3","mzys3","ssjczbm4","ssjczrq4","ssjb4","ssjczmc4","sz4","yz4","ez4","qkdj4","qkyhlb4","mzfs4",
					 "mzys4","ssjczbm5","ssjczrq5","ssjb5","ssjczmc5","sz5","yz5","ez5","qkdj5","qkyhlb5","mzfs5","mzys5",
					 "ssjczbm6","ssjczrq6","ssjb6","ssjczmc6","sz6","yz6","ez6","qkdj6","qkyhlb6","mzfs6","mzys6","ssjczbm7",
					 "ssjczrq7","ssjb7","ssjczmc7","sz7","yz7","ez7","qkdj7","qkyhlb7","mzfs7","mzys7","lyfs","yzzy_yljg","wsy_yljg",
					 "sfzzyjh","md","ryq_t","ryq_xs","ryq_f","ryh_t","ryh_xs","ryh_f","zfy","zfje","ylfuf","zlczf","hlf","qtfy",
					 "blzdf","syszdf","yxxzdf","lczdxmf","fsszlxmf","wlzlf","sszlf","maf","ssf","kff","zyzlf","xyf","kjywf","zcyf",
					 "zcyf1","xf","bdblzpf","qdblzpf","nxyzlzpf","xbyzlzpf","hcyyclf","yyclf","ycxyyclf","qtf"};
		}
		return fs;
	}
}
