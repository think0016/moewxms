package me.moe.modules.weixin.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class Wx_MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("wx_attachment", "id", Attachment.class);
		arp.addMapping("wx_auto_reply", "id", AutoReply.class);
		arp.addMapping("wx_custom_menu", "id", CustomMenu.class);
		arp.addMapping("wx_keyword", "id", Keyword.class);
		arp.addMapping("wx_material_file", "id", MaterialFile.class);
		arp.addMapping("wx_material_image", "id", MaterialImage.class);
		arp.addMapping("wx_material_news", "id", MaterialNews.class);
		arp.addMapping("wx_material_text", "id", MaterialText.class);
		arp.addMapping("wx_public", "id", Public.class);
		arp.addMapping("wx_public_follow", "id", PublicFollow.class);
		arp.addMapping("wx_public_tags", "id", PublicTags.class);
	}
}

