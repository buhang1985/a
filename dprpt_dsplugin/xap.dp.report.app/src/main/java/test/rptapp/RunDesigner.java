package test.rptapp;

import java.util.ArrayList;

import xap.dp.report.app.App;

/**
 * 启动报表设计器，单机版将使用 xaprpt_lc.properties 配置文件
 * 
 * @author QiYongsheng
 */
public class RunDesigner {
	
	public static void main(String[] args) {
		// 参数列表，存在重复时以最后一个为准
		ArrayList<String> rpt_args_list = new ArrayList<String>(15);
		
		rpt_args_list.add("-csd:LC");
		//rpt_args_list.add("-cfgfile:xaprpt_lc.properties"); // 配置文件路径
		rpt_args_list.add("-lang:zh_CN"); // 语言环境
		
		// 启动参数
		int args_cnt = (null==args ? 0 : args.length);
		if(args_cnt > 0) {
			for(int ix=0; ix<args_cnt; ix++) {
				String str_arg = args[ix];
				
				if(args[ix].startsWith("-cfgfile:")) { // 配置文件路径
					rpt_args_list.add(str_arg);
				}
			}
		}
		
		String[] rpt_args = rpt_args_list.toArray(new String[0]);
		App.startFrame(rpt_args);
	}
}
