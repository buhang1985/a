package iih.pe.report.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sun.rowset.CachedRowSetImpl;

import iih.pe.pqry.peresultcontrast.d.PeResultContrast;
import iih.pe.report.bp.qry.SqlQryBp;
import iih.pe.report.dto.rpt.PePsnApptDTO;
import iih.pe.report.dto.rpt.PeRstDTO;
import iih.pe.report.dto.rpt.PeRstHistDTO;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetHisRptBp {
	
	private List<PeRstHistDTO> list;
	
	@SuppressWarnings("unchecked")
	public void exec (String id_pepsnbinfo, String id_pepsnappt) throws Exception {
		//参数非空验证
		if (valida(id_pepsnbinfo)) {
			return;
		}
		if (valida(id_pepsnappt)) {
			return;
		}
		//返回查询结果
		List<PeRstHistDTO> rstHisDtoList = null;//本次体检结果
		SqlQryBp peRstQry = new SqlQryBp();
		//获取体检记录
		rstHisDtoList = (List<PeRstHistDTO>)getResultListBySql(peRstQry.getQrySQLStrOfHisDto(id_pepsnappt), PeRstHistDTO.class);
		//查询该体检客户是否有历史体检
		List<PePsnApptDTO> apptDosCur = (List<PePsnApptDTO>)getResultListBySql(peRstQry.getQrySQLStrOfPsnAppt(id_pepsnappt), PePsnApptDTO.class);
		if(apptDosCur.size() > 0){
			List<PePsnApptDTO> apptDos = (List<PePsnApptDTO>)getResultListBySql(peRstQry.getQrySQLStrOfPsnAppt(id_pepsnbinfo, id_pepsnappt, apptDosCur.get(0).getDt_pe().toString()), PePsnApptDTO.class);
			//历史体检
			if(apptDos.size() > 0){//上次体检结果不为空
				//取得上次体检结果
				List<PeRstDTO> PeRstDTOs_1 = (List<PeRstDTO>)getResultListBySql(peRstQry.getQrySQLStrOfRstDtos(apptDos.get(0).getId_pepsnappt()), PeRstDTO.class);
				for(PeRstHistDTO his : rstHisDtoList){
					String id_peitem = his.getId_pesrvitem();
					for(PeRstDTO rst : PeRstDTOs_1){
						if(id_peitem.equals(rst.getId_pesrvitem())){
							his.setRst_1(rst.getRst());
							his.setDt_pe_1(rst.getDt_pe());
							his.setUnit(rst.getUnit());
						}
					}
				}
			}
			if(apptDos.size() > 1){
				//获取上上次体检结果
				List<PeRstDTO> PeRstDTOs_2 = (List<PeRstDTO>)getResultListBySql(peRstQry.getQrySQLStrOfRstDtos(apptDos.get(1).getId_pepsnappt()), PeRstDTO.class);
				for(PeRstHistDTO his : rstHisDtoList){
					String id_peitem = his.getId_pesrvitem();
					for(PeRstDTO rst : PeRstDTOs_2){
						if(id_peitem.equals(rst.getId_pesrvitem())){
							his.setRst_2(rst.getRst());
							his.setDt_pe_2(rst.getDt_pe());
						}
					}
				}
			}
		}
		list = rstHisDtoList;
	}
	
	//体重指数与腰臀比
	public List<PeResultContrast> exec1(){
		List<PeResultContrast> result = new ArrayList<PeResultContrast>(); 
		PeResultContrast peResult1 = new PeResultContrast();
		PeResultContrast peResult2 = new PeResultContrast();
		PeResultContrast peResult3 = new PeResultContrast();
		for(PeRstHistDTO dto : list){
			if("体重指数".equals(dto.getName_item())){
				peResult1.setDt_pe(dto.getDt_pe_0());
				peResult1.setBMI(dto.getRst_0());
				peResult2.setDt_pe(dto.getDt_pe_1());
				peResult2.setBMI(dto.getRst_1());
				peResult3.setDt_pe(dto.getDt_pe_2());
				peResult3.setBMI(dto.getRst_2());
			}
			if("腰臀比".equals(dto.getName_item())){
				peResult1.setYaoTun(dto.getRst_0());
				peResult2.setYaoTun(dto.getRst_1());
				peResult3.setYaoTun(dto.getRst_2());
			}
		}
		result.add(peResult1);
		result.add(peResult2);
		result.add(peResult3);
		return result;
	}
	
	//高血压
	public List<PeResultContrast> exec2(){
		List<PeResultContrast> result = new ArrayList<PeResultContrast>(); 
		PeResultContrast peResult1 = new PeResultContrast();
		PeResultContrast peResult2 = new PeResultContrast();
		PeResultContrast peResult3 = new PeResultContrast();
		for(PeRstHistDTO dto : list){
			if("收缩压(mmHg)".equals(dto.getName_item())){
				peResult1.setDt_pe(dto.getDt_pe_0());
				peResult1.setShouSuo(dto.getRst_0());
				peResult2.setDt_pe(dto.getDt_pe_1());
				peResult2.setShouSuo(dto.getRst_1());
				peResult3.setDt_pe(dto.getDt_pe_2());
				peResult3.setShouSuo(dto.getRst_2());
			}
			if("舒张压(mmHg)".equals(dto.getName_item())){
				peResult1.setShuZhang(dto.getRst_0());
				peResult2.setShuZhang(dto.getRst_1());
				peResult3.setShuZhang(dto.getRst_2());
			}
			if("高血压病史".equals(dto.getName_item())){
				peResult1.setGaoXueYa(dto.getRst_0());
				peResult2.setGaoXueYa(dto.getRst_1());
				peResult3.setGaoXueYa(dto.getRst_2());
			}
		}
		result.add(peResult1);
		result.add(peResult2);
		result.add(peResult3);
		return result;
	}
	
	//血脂
	public List<PeResultContrast> exec3(){
		List<PeResultContrast> result = new ArrayList<PeResultContrast>(); 
		PeResultContrast peResult1 = new PeResultContrast();
		PeResultContrast peResult2 = new PeResultContrast();
		PeResultContrast peResult3 = new PeResultContrast();
		for(PeRstHistDTO dto : list){
			if("总胆固醇".equals(dto.getName_item())){
				peResult1.setDt_pe(dto.getDt_pe_0());
				peResult1.setDanGuChun(dto.getRst_0());
				peResult2.setDt_pe(dto.getDt_pe_1());
				peResult2.setDanGuChun(dto.getRst_1());
				peResult3.setDt_pe(dto.getDt_pe_2());
				peResult3.setDanGuChun(dto.getRst_2());
			}
			if("甘油三酯".equals(dto.getName_item())){
				peResult1.setGanYouSanZhi(dto.getRst_0());
				peResult2.setGanYouSanZhi(dto.getRst_1());
				peResult3.setGanYouSanZhi(dto.getRst_2());
			}
			if("高密度脂蛋白胆固醇".equals(dto.getName_item())){
				peResult1.setGaomidu(dto.getRst_0());
				peResult2.setGaomidu(dto.getRst_1());
				peResult3.setGaomidu(dto.getRst_2());
			}
			if("低密度脂蛋白胆固醇".equals(dto.getName_item())){
				peResult1.setDimidu(dto.getRst_0());
				peResult2.setDimidu(dto.getRst_1());
				peResult3.setDimidu(dto.getRst_2());
			}
		}
		result.add(peResult1);
		result.add(peResult2);
		result.add(peResult3);
		return result;
	}
	
	//空腹血糖
	public List<PeResultContrast> exec4(){
		List<PeResultContrast> result = new ArrayList<PeResultContrast>(); 
		PeResultContrast peResult1 = new PeResultContrast();
		PeResultContrast peResult2 = new PeResultContrast();
		PeResultContrast peResult3 = new PeResultContrast();
		for(PeRstHistDTO dto : list){
			if("血糖".equals(dto.getName_item())){
				peResult1.setDt_pe(dto.getDt_pe_0());
				peResult1.setXueTang(dto.getRst_0());
				peResult2.setDt_pe(dto.getDt_pe_1());
				peResult2.setXueTang(dto.getRst_1());
				peResult3.setDt_pe(dto.getDt_pe_2());
				peResult3.setXueTang(dto.getRst_2());
			}
		}
		result.add(peResult1);
		result.add(peResult2);
		result.add(peResult3);
		return result;
	}

	/**
	 * 基础参数校验
	 * @param dt_monday
	 * @param id_dep_nur
	 * @return
	 */
    private boolean valida(String id_pepsnappt) {
    	return (StringUtils.isEmpty(id_pepsnappt));
    }
    
	/**
	 * 使用泛型，返回数据库结果集
	 * @param strSql
	 * @param classinfo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Object getResultListBySql(String strSql,Class<?> classinfo) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(classinfo);
		List<Object> result = (List<Object>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}
	
	

	
	
	
}
