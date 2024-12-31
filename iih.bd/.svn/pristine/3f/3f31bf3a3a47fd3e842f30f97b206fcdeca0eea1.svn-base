package iih.bd.srv.medsrv.validate;

import java.util.List;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/// <summary>
    /// <para>描    述 :  基础校验基类                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.bd.srv.medsrv.validate    </para>    
    /// <para>类 名 称 :  BDBaseSrvValidate					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  10/20/2016 1:43:53 PM             </para>
    /// <para>更新时间 :  10/20/2016 1:43:53 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class BDBaseSrvValidate implements IMedSrvValidate
    {
        public  Boolean CheckValidate(MedSrvDO medsrv, List<BDErrorInfo> errorList) throws BizException
        {
            
        	BDErrorInfo info = new BDErrorInfo(medsrv.getId_srv(),medsrv.getName());
        	CheckSrvCommonInfo(medsrv, info.getDescList());
            if (info.getDescList().size() > 0){
    			errorList.add(info);
    		}
    		return info.getDescList().size() == 0;
        }

        protected  void CheckSrvCommonInfo(MedSrvDO s, List<String> e)
        {
            if (StringUtil.isEmpty(s.getId_org()))
            {
                e.add("所属集团为空");
            }
            if (StringUtil.isEmpty(s.getId_grp()))
            {
                e.add("所属组织为空");
            }
            if (StringUtil.isEmpty(s.getId_srvca()))
            {
                e.add("服务分类为空");
            }
            if (StringUtil.isEmpty(s.getId_srvtp()))
            {
                e.add("服务类型为空");
            }
            if (StringUtil.isEmpty(s.getSd_srvtp()))
            {
                e.add("服务类型编码为空");
            }
            else
            {
                if (s.getSd_srvtp().length()< 4)
                {
                    e.add("服务类型选择错误！服务类型编码长度不能小于4位");
                }
            }
            if (StringUtil.isEmpty(s.getSrvca_innercode()))
            {
                e.add("服务分类内编码为空");
                
            }
            if (StringUtil.isEmpty(s.getName()))
            {
                e.add("服务名称为空");
            }
            if (StringUtil.isEmpty(s.getId_unit_med()))
            {
                e.add("剂量单位为空");
                
            }
            if (StringUtil.isEmpty(s.getId_primd()))
            {
                e.add("定价模式为空");
            }else{
            	if(s.getId_primd()==IBdPrimdCodeConst.ID_PRI_SRV){
               	 if (s.getEu_blmd()==null)
                    {
                        e.add("划价方式为空");
                    }
               }
              
            }
            if (s.getFg_ctm().equals(null))
            {
                e.add("自定义服务标识为空");
            }
             if (s.getFg_or().equals(null))
            {
                e.add("医嘱可开立标识为空");
            }
             if (s.getFg_mm().equals(null))
            {
                e.add("物品标识为空");
            }
             if (s.getFg_bl().equals(null))
            {
                e.add("费用标识为空");
            }
            if (s.getFg_set().equals(null))
            {
                e.add("服务套标识为空");
            }
            else
            {
                if (s.getFg_set()==FBoolean.TRUE)
                {
                    if (StringUtil.isEmpty(s.getId_setord()))
                    {
                        e.add("服务套开立方式为空");
                    }
                    if (StringUtil.isEmpty(s.getSd_setord()))
                    {
                        e.add("服务套开立方式编码为空");
                    }
                }
            }
            
            if (s.getFg_use_op()==null)
            {
                e.add("门诊可使用标识为空");
            }
            else
            {
                if (s.getFg_mm() == FBoolean.FALSE || s.getFg_use_op()==FBoolean.FALSE) return;
                if (StringUtil.isEmpty(s.getId_mmbind_op()))
                {
                    e.add("门诊物品绑定时机为空");
                }
                if (StringUtil.isEmpty(s.getSd_mmbind_op()))
                {
                    e.add("门诊物品绑定时机编码为空");
                }
            }
            if (s.getFg_use_ip()==null)
            {
                e.add("住院可使用标识为空");
            }
            else
            {
                if (s.getFg_mm() == FBoolean.FALSE || s.getFg_use_ip()==FBoolean.FALSE) return;
                if (StringUtil.isEmpty(s.getId_mmbind_ip()))
                {
                    e.add("住院物品绑定时机为空");
                }
                if (StringUtil.isEmpty(s.getId_mmbind_ip()))
                {
                    e.add("住院物品绑定时机编码为空");
                }
            }
            if (s.getFg_use_er()==null)
            {
                e.add("急诊可使用标识为空");
            }
            else
            {
                if (s.getFg_mm() == FBoolean.FALSE || s.getFg_use_er()==FBoolean.FALSE) return;
                if (StringUtil.isEmpty(s.getId_mmbind_er()))
                {
                    e.add("急诊物品绑定时机为空");
                }
                if (StringUtil.isEmpty(s.getId_mmbind_er()))
                {
                    e.add("急诊物品绑定时机编码为空");
                }
            }
            if (s.getFg_use_pe()==null)
            {
                e.add("体检可使用标识为空");
            }
            else
            {
                if (s.getFg_mm() == FBoolean.FALSE || s.getFg_use_pe()==FBoolean.FALSE) return;
                if (StringUtil.isEmpty(s.getId_mmbind_pe()))
                {
                    e.add("体检物品绑定时机为空");
                }
                if (StringUtil.isEmpty(s.getId_mmbind_pe()))
                {
                    e.add("体检物品绑定时机编码为空");
                }
            }
            if (s.getFg_use_fm()==null)
            {
                e.add("家庭可使用标识为空");
            }
            else
            {
                if (s.getFg_mm() == FBoolean.FALSE || s.getFg_use_fm()==FBoolean.FALSE) return;
                if (StringUtil.isEmpty(s.getId_mmbind_fm()))
                {
                    e.add("家庭物品绑定时机为空");
                }
                if (StringUtil.isEmpty(s.getId_mmbind_fm()))
                {
                    e.add("家庭物品绑定时机编码为空");
                }
            }

        }

        
    }
