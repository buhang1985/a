package iih.ei.std.s.v1.bp.mp.basedata;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.DeptInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.DeptInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.basedata.qry.DeptInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 
* @ClassName: GetDeptInfoBp
* @Description: 获取部门基础数据
* @author zhy
* @date 2019年9月24日
*
 */
@SuppressWarnings("unchecked")
public class GetDeptInfoBp extends IIHServiceBaseBP<BaseParamDTO,DeptInfoResultDTO> {
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(BaseParamDTO param) throws BizException {
		if (null == param.getPageinfo() || param.getPageinfo().size() < 1) {
			throw new BizException("未传入分页信息");
		}
	}
    
	/**
	 * 核心业务
	 */
	@Override
	protected DeptInfoResultDTO process(BaseParamDTO param) throws BizException {
		DeptInfoResultDTO resultDTO = new  DeptInfoResultDTO();
		DeptInfoSql sql = new DeptInfoSql();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<DeptInfoDTO> findPagingData = findPagingData(pageInfoDto, sql.getQrySQLStr(), sql.getQryParameter(null), DeptInfoDTO.class);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setDeptinfo(ArrayListUtil.ConvertToFArrayList(findPagingData));
		return resultDTO;
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,DeptInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}

}
