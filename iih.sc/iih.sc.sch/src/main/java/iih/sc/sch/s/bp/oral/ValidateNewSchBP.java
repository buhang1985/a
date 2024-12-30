package iih.sc.sch.s.bp.oral;

import java.util.ArrayList;
import java.util.List;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.s.ep.SchEP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 验证新增排班
 * 
 * @author yank
 *
 */
public class ValidateNewSchBP {
	private List<String> nPlList = new ArrayList<String>();
	private List<String> nSchDateList = new ArrayList<String>();
	private List<String> nDayslotList = new ArrayList<String>();
	private List<String> nQueSiteList = new ArrayList<String>();	

	/**
	 * 验证新增排班
	 * 
	 * @param schDtoList
	 * @throws BizException
	 */
	public void exec(List<SchOralInfoDTO> schDtoList) throws BizException {
		if(ListUtil.isEmpty(schDtoList))
			return;
		
		// 1、验证完整性和初始化
		this.validateAndInit(schDtoList);

		// 2、获取计划已有排班
		List<SchOralInfoDTO> existedPlSchList = this.getPlSchList();

		// 3、获取诊椅已有排班
		List<SchOralInfoDTO> existedChairSchList = this.getChairSchList();		
		if(ListUtil.isEmpty(existedPlSchList) && ListUtil.isEmpty(existedChairSchList)){
			return;
		}
		List<SchOralInfoDTO> usedSchList = new ArrayList<SchOralInfoDTO>();
		List<SchOralInfoDTO> otherChairSchList = new ArrayList<SchOralInfoDTO>();
		List<String> needDelSchList = new ArrayList<String>();
		for (SchOralInfoDTO nSchDTO : schDtoList) {
			// 4、判定已使用或者已排班的诊椅
			for (SchOralInfoDTO oSchDTO : existedChairSchList) {
				if (isSame(oSchDTO, nSchDTO)) {
					if (oSchDTO.getQuan_total_used() > 0) {
						usedSchList.add(oSchDTO);
						continue;						
					}
					needDelSchList.add(oSchDTO.getId_sch());
				}
			}

			// 5、计划在其他诊椅有排班
			for (SchOralInfoDTO oSchDTO : existedPlSchList) {
				if (isSameWithoutSite(oSchDTO, nSchDTO)) {
					otherChairSchList.add(oSchDTO);
				}
			}
		}
		//有已使用的排班，则抛异常
		if(!ListUtil.isEmpty(usedSchList)){
			String errorMsg = formatErrorMsg(usedSchList,IScMsgConst.SC_SCH_EXIST_USED_SCH);
			throw new BizException(errorMsg);// 已使用的抛异常
		}
		
		//计划在其他诊椅有排班，则抛异常
		if(!ListUtil.isEmpty(otherChairSchList)){
			String errorMsg = formatErrorMsg(otherChairSchList,IScMsgConst.SC_SCH_PL_HAS_SCH_IN_OTHERSITE);
			throw new BizException(errorMsg);
		}
		
		// 6、删除已经存在未使用的排班
		new SchEP().delete(needDelSchList.toArray(new String[0]));
	}

	/**
	 * 验证并初始化
	 * 
	 * @param schDtoList 排班集合
	 * @throws BizException
	 */
	private void validateAndInit(List<SchOralInfoDTO> schDtoList) throws BizException {
		StringBuilder errorBuilder = new StringBuilder();
		for (SchOralInfoDTO schDTO : schDtoList) {
			validateIntegrity(schDTO,errorBuilder);
			if (!StringUtil.isEmpty(schDTO.getId_scpl()) && !nPlList.contains(schDTO.getId_scpl())) {
				nPlList.add(schDTO.getId_scpl());
			}
			if (schDTO.getD_sch()!=null && !nSchDateList.contains(schDTO.getD_sch().toStdString())) {
				nSchDateList.add(schDTO.getD_sch().toStdString());
			}
			if (!StringUtil.isEmpty(schDTO.getId_dayslot()) && !nDayslotList.contains(schDTO.getId_dayslot())) {
				nDayslotList.add(schDTO.getId_dayslot());
			}
			if (!StringUtil.isEmpty(schDTO.getId_quesite()) && !nQueSiteList.contains(schDTO.getId_quesite())) {
				nQueSiteList.add(schDTO.getId_quesite());
			}
		}
		//如有错误信息，则抛异常
		if(!StringUtil.isEmpty(errorBuilder.toString())){
			throw new BizException(IScMsgConst.SC_SCH_INFO_INCOMPLETE);//没有一个更好的方式提示，暂时扼要提示
		}
	}

	/**
	 * 验证排班数据完整性
	 * 
	 * @param schDTO 排班DTO
	 * @throws BizException
	 */
	private void validateIntegrity(SchOralInfoDTO schDTO,StringBuilder errorBuilder) throws BizException {
		if(StringUtil.isEmpty(schDTO.getId_scpl())){
			errorBuilder.append("排班计划为空,");
		}
		if(schDTO.getD_sch()==null){
			errorBuilder.append("排班日期为空,");
		}
		if(StringUtil.isEmpty(schDTO.getId_dayslot())){
			errorBuilder.append("午别为空,");
		}
		if(StringUtil.isEmpty(schDTO.getId_quesite())){
			errorBuilder.append("站点为空,");
		}
		if(schDTO.getQuan_total()==null ){
			errorBuilder.append("总号源数为空");
		}
	}

	/**
	 * 获取诊椅的排班集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<SchOralInfoDTO> getChairSchList() throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_SCH,D_SCH,SCH.ID_DAYSLOT,DAYSLOT.NAME AS NAME_DAYSLOT,SCH.ID_SCPL,PL.NAME AS NAME_SCPL,");
		sqlBuilder.append("SCH.ID_QUESITE,SITE.NAME AS NAME_QUESITE,QUAN_TOTAL_USED ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("LEFT JOIN SC_PL AS PL ON PL.ID_SCPL=SCH.ID_SCPL ");
		sqlBuilder.append("LEFT JOIN BD_DAYSLOT AS DAYSLOT ON DAYSLOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
		sqlBuilder.append("LEFT JOIN BD_QUE_SITE AS SITE ON SITE.ID_QUESITE=SCH.ID_QUESITE ");
		sqlBuilder.append("WHERE 1=1 ");
		sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.D_SCH", nSchDateList));
		sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.ID_DAYSLOT", nDayslotList));
		sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.ID_QUESITE", nQueSiteList));

		List<SchOralInfoDTO> schList = (List<SchOralInfoDTO>) new DAFacade().execQuery(sqlBuilder.toString(),
				new BeanListHandler(SchOralInfoDTO.class));
		return schList;
	}

	/**
	 * 获取计划的排班集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<SchOralInfoDTO> getPlSchList() throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_SCH,D_SCH,SCH.ID_DAYSLOT,DAYSLOT.NAME AS NAME_DAYSLOT,");
		sqlBuilder.append("SCH.ID_SCPL,PL.NAME AS NAME_SCPL,");
		sqlBuilder.append("SCH.ID_QUESITE,SITE.NAME AS NAME_QUESITE,QUAN_TOTAL_USED ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("LEFT JOIN SC_PL AS PL ON PL.ID_SCPL=SCH.ID_SCPL ");
		sqlBuilder.append("LEFT JOIN BD_DAYSLOT AS DAYSLOT ON DAYSLOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
		sqlBuilder.append("LEFT JOIN BD_QUE_SITE AS SITE ON SITE.ID_QUESITE=SCH.ID_QUESITE ");
		sqlBuilder.append("WHERE 1=1 ");
		sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.D_SCH", nSchDateList));
		sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.ID_DAYSLOT", nDayslotList));
		sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.ID_SCPL", nPlList));

		List<SchOralInfoDTO> schList = (List<SchOralInfoDTO>) new DAFacade().execQuery(sqlBuilder.toString(),
				new BeanListHandler(SchOralInfoDTO.class));
		return schList;
	}

	/**
	 * 是否相同 计划、日期、日期分组、诊椅相同，则认为相同
	 * 
	 * @param existedSchDTO 已有排班DO
	 * @param nSchDO 新增排班DTO
	 * @return
	 */
	private boolean isSame(SchOralInfoDTO existedSchDTO, SchOralInfoDTO nSchDO) {
		return (existedSchDTO.getId_scpl().equals(nSchDO.getId_scpl())
				&& existedSchDTO.getD_sch().isSameDate(nSchDO.getD_sch())
				&& existedSchDTO.getId_dayslot().equals(nSchDO.getId_dayslot())
				&& existedSchDTO.getId_quesite().equals(nSchDO.getId_quesite()));
	}

	/**
	 * 是否相同 计划、日期、日期分组相同，站点不相等
	 * 
	 * @param existedSchDO 已有排班DO
	 * @param nSchDTO 新增排班DTO
	 * @return
	 */
	private boolean isSameWithoutSite(SchOralInfoDTO existedSchDO, SchOralInfoDTO nSchDTO) {
		return (existedSchDO.getId_scpl().equals(nSchDTO.getId_scpl())
				&& existedSchDO.getD_sch().isSameDate(nSchDTO.getD_sch())
				&& existedSchDO.getId_dayslot().equals(nSchDTO.getId_dayslot())
				&& !existedSchDO.getId_quesite().equals(nSchDTO.getId_quesite()));
	}
	/**
	 * 格式化消息
	 * @param schList 排班集合
	 * @param error 错误提示
	 * @return
	 */
	private String formatErrorMsg(List<SchOralInfoDTO> schList,String error){
		StringBuilder builder = new StringBuilder();
		int size = ListUtil.isEmpty(schList) ? 0 : schList.size();
		for(int i=0;i<size;i++){
			builder.append(String.format("[%s  %s]%s", schList.get(i).getD_sch().toStdString(),schList.get(i).getName_dayslot(),schList.get(i).getName_scpl()));	
			builder.append("\n");
		}		
		builder.append(error);
		
		return builder.toString();
	}
}
