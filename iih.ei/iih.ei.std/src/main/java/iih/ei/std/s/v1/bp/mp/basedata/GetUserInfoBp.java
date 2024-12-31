package iih.ei.std.s.v1.bp.mp.basedata;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.UserInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.UserInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.basedata.qry.UserInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 
* @ClassName: GetUserInfoBp
* @Description: 获取用户基础数据
* @author zhy
* @date 2019年9月23日
*
 */
@SuppressWarnings("unchecked")
public class GetUserInfoBp extends IIHServiceBaseBP<BaseParamDTO,UserInfoResultDTO> {
    
	/**
	 * 数据校验
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
	protected UserInfoResultDTO process(BaseParamDTO param) throws BizException {
		UserInfoResultDTO resultDTO = new UserInfoResultDTO();
		UserInfoSql sql = new UserInfoSql();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<UserInfoDTO> findPagingData = findPagingData(pageInfoDto, sql.getQrySQLStr(), sql.getQryParameter(null), UserInfoDTO.class);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setUserinfo(ArrayListUtil.ConvertToFArrayList(findPagingData));
		return resultDTO;
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,UserInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}

}
