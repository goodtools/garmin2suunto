package cn.lujiawu.app.about;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;

import com.danielstone.materialaboutlibrary.ConvenienceBuilder;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import androidx.core.content.ContextCompat;
import cn.lujiawu.app.R;

public class MyAbouts {

    public static MaterialAboutList createMaterialAboutList(final Context c, final int colorIcon, final int theme) {
        MaterialAboutCard.Builder appCardBuilder = new MaterialAboutCard.Builder();

        // Add items to card

        appCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text("Garmin2Move")
                .desc("© 2019 山虎hz")
                .icon(R.drawable.ic_launcher)
                .build());

        appCardBuilder.addItem(ConvenienceBuilder.createVersionActionItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_information_outline)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Version",
                false));

        MaterialAboutCard.Builder authorCardBuilder = new MaterialAboutCard.Builder();
        authorCardBuilder.title("作者");
//        authorCardBuilder.titleColor(ContextCompat.getColor(c, R.color.colorAccent));

        authorCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text("lujiawu12")
                .subText("hangzhou")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .build());

        authorCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text("Fork on GitHub")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_github_circle)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(c, Uri.parse("https://github.com/jiawulu")))
                .build());

        authorCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .text("程序员 runner")
                .icon(new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_account_card_details)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18))
                .build());

        authorCardBuilder.addItem(ConvenienceBuilder.createEmailItem(c,
                new IconicsDrawable(c)
                        .icon(CommunityMaterial.Icon.cmd_email)
                        .color(ContextCompat.getColor(c, colorIcon))
                        .sizeDp(18),
                "Send an email",
                true,
                "jiawu.lu@gmail.com",
                ""));

        MaterialAboutCard.Builder otherCardBuilder = new MaterialAboutCard.Builder();
        otherCardBuilder.title("简介");

        otherCardBuilder.addItem(new MaterialAboutActionItem.Builder()
                .subTextHtml(HTML)
                .setIconGravity(MaterialAboutActionItem.GRAVITY_TOP)
                .build()
        );

        return new MaterialAboutList(appCardBuilder.build(), authorCardBuilder.build(), otherCardBuilder.build());
    }

    private static final String HTML = " <article class=\"markdown-body entry-content\" itemprop=\"text\"><h3><a id=\"user-content-背景\" class=\"anchor\" aria-hidden=\"true\" href=\"#背景\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>背景</h3>\n" +
            "<p>作为garmin和keep的重度用户，一直受困于2者之间的数据不能同步，以至于每次跑步都必须揣着手机，十分不爽。不过最近keep和suunto数据上打通了，加上之前无意在知乎 <a href=\"https://www.zhihu.com/question/46991660\" rel=\"nofollow\">https://www.zhihu.com/question/46991660</a> 上发现garmin的数据其实可以通过接口写入到suunto里去的，这些基础条件的成熟触发了这个项目的落地</p>\n" +
            "<h4><a id=\"user-content-为什么要再造轮子\" class=\"anchor\" aria-hidden=\"true\" href=\"#为什么要再造轮子\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>为什么要再造轮子</h4>\n" +
            "<ol>\n" +
            "<li>mxactivitymover提供的是一个jar版本的程序，基于桌面版，现在跑友们都是拿着手机，十分不方便</li>\n" +
            "<li>程序对我来说有些bug，主要是时区的区别， mxactivitymover 取的时间用的是标准时间，而我们再东8区，导致sunnto的运动记录被提前了8小时</li>\n" +
            "<li>操作相对来说还是不是特别方便，估计也很久没做更新维护了</li>\n" +
            "</ol>\n" +
            "<h3><a id=\"user-content-目标\" class=\"anchor\" aria-hidden=\"true\" href=\"#目标\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>目标</h3>\n" +
            "<p>方便跑友们快速的把garmin产生的运动数据同步到suunto上去，方遍其他第三方程序再从sunnto同步，比如keep</p>\n" +
            "<h3><a id=\"user-content-实现\" class=\"anchor\" aria-hidden=\"true\" href=\"#实现\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>实现</h3>\n" +
            "<ol>\n" +
            "<li>根据时间倒排序获取garmin中的运动记录</li>\n" +
            "<li>再到suunto的服务器上读相应的运动记录，如果记录匹配，则表示同步完成，如果未匹配进入下一步</li>\n" +
            "<li>同步数据\n" +
            "<ol>\n" +
            "<li>根据garmin的运动id获取运动数据详情，包括splites和details</li>\n" +
            "<li>根据mxactivitymover提供的接口，将garmin的数据转换到suunto的数据结构</li>\n" +
            "<li>调用sunnto的接口进行记录保存</li>\n" +
            "</ol>\n" +
            "</li>\n" +
            "</ol>\n" +
            "<h3><a id=\"user-content-致谢\" class=\"anchor\" aria-hidden=\"true\" href=\"#致谢\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>致谢</h3>\n" +
            "<ol>\n" +
            "<li>感谢mxactivitymover为我提供了api的调用参考</li>\n" +
            "<li>感谢garmin和suunto提供的api接口</li>\n" +
            "<li>感谢开源\n" +
            "<ul>\n" +
            "<li><a href=\"https://github.com/ReactiveX/RxJava\">RxJava</a> 一个专注于异步编程与控制可观察数据（或者事件）流的API</li>\n" +
            "<li><a href=\"https://github.com/ReactiveX/RxAndroid\">RxAndroid</a> 为了在Android中使用RxJava</li>\n" +
            "<li><a href=\"https://github.com/square/retrofit\">Retrofit</a> 安全的HTTP请求工具库</li>\n" +
            "<li><a href=\"https://github.com/daniel-stoneuk/material-about-library\">material-about-library</a> 让你更容易的创建美丽的关于页面</li>\n" +
            "<li><a href=\"https://github.com/d-max/spots-dialog\">spots-dialog</a> 让你更容易的创建加载动画</li>\n" +
            "</ul>\n" +
            "</li>\n" +
            "</ol>\n" +
            "</article>";

}