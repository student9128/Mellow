package com.kevin.mellow.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/16.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanMovieDetailBean {

    /**
     * rating : {"max":10,"average":7.2,"details":{"1":63,"3":4158,"2":467,"5":1250,"4":4774},"stars":"40","min":0}
     * reviews_count : 265.0
     * videos : []
     * wish_count : 14037.0
     * original_title : Jumanji: Welcome to the Jungle
     * blooper_urls : ["http://vt1.doubanio.com/201801161528/46efa81681b69c50f251ff4141ec3389/view/movie/M/302260076.mp4","http://vt1.doubanio.com/201801161528/998bd768c7ed143785ee3471d7a8e33e/view/movie/M/302250844.mp4","http://vt1.doubanio.com/201801161528/e0065c926277d2d99a5f06dd695f5a7c/view/movie/M/302250022.mp4","http://vt1.doubanio.com/201801161528/ca0fc1c3806f720686751762afbdeff4/view/movie/M/302240932.mp4"]
     * collect_count : 36121.0
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506258944.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506258944.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506258944.jpg"}
     * douban_site :
     * year : 2017
     * popular_comments : [{"rating":{"max":5,"value":4,"min":0},"useful_count":43,"author":{"uid":"zhecx","avatar":"https://img1.doubanio.com/icon/u2166920-17.jpg","signature":"好男人就是反复睡一个妞睡一辈子","alt":"https://www.douban.com/people/zhecx/","id":"2166920","name":"我就是树袋熊"},"subject_id":"26586766","content":"笑翻啊啊啊啊 哈哈哈哈哈哈哈 黑人太搞笑了 虽然最后感觉有点蛇尾 还是值得四星","created_at":"2017-12-17 00:15:23","id":"1287382501"},{"rating":{"max":5,"value":4,"min":0},"useful_count":33,"author":{"uid":"1591741","avatar":"https://img3.doubanio.com/icon/u1591741-2.jpg","signature":"","alt":"https://www.douban.com/people/1591741/","id":"1591741","name":"HarperDie"},"subject_id":"26586766","content":"三星半。这或许是2017年目前为止拍的最工整的商业类型片。抛开初始部分铺垫略冗，全片的行进节奏相当流畅。简化的主线、适时的笑料填补，再加上几位演员相当不俗的喜剧表演能力，令观者代入感颇佳。但年轻演员的表演，一些转折性的段落，显然还有推敲的空间。","created_at":"2017-12-20 17:44:28","id":"1289584679"},{"rating":{"max":5,"value":4,"min":0},"useful_count":208,"author":{"uid":"tjz230","avatar":"https://img1.doubanio.com/icon/u1005928-127.jpg","signature":"","alt":"https://www.douban.com/people/tjz230/","id":"1005928","name":"影志"},"subject_id":"26586766","content":"承载第一部情怀，足够的合家欢和爆米花，色香味俱全。珍惜生命，远离游戏。","created_at":"2017-12-15 16:48:35","id":"1286570131"},{"rating":{"max":5,"value":5,"min":0},"useful_count":305,"author":{"uid":"some_Ji","avatar":"https://img3.doubanio.com/icon/u2218962-374.jpg","signature":"我觉得，我也老了... ...","alt":"https://www.douban.com/people/some_Ji/","id":"2218962","name":"伪淡定小姐"},"subject_id":"26586766","content":"非常有趣，完美的续集。老少咸宜（部分不咸宜233）笑点充足，影院里全场哄堂大笑N次。Kevin真的是自带笑点的存在哈哈哈哈。性格/别反转的演技都很到位，功夫熊猫真的超赞了！巨石强森终于不只有一种类型片了！遇到爆米花该笑的就笑一笑，生活那么多压力，何必ging到要死XD。","created_at":"2017-12-27 00:58:36","id":"1217995565"}]
     * alt : https://movie.douban.com/subject/26586766/
     * id : 26586766
     * mobile_url : https://movie.douban.com/subject/26586766/mobile
     * photos_count : 297.0
     * pubdate : 2018-01-12
     * title : 勇敢者游戏：决战丛林
     * has_video : false
     * share_url : https://m.douban.com/movie/subject/26586766
     * languages : ["英语"]
     * schedule_url : https://movie.douban.com/subject/26586766/cinema/
     * writers : [{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg"},"name_en":"Chris McKenna","name":"克里斯·麦克纳","alt":"https://movie.douban.com/celebrity/1331505/","id":"1331505"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948582.44.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948582.44.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948582.44.jpg"},"name_en":"Erik Sommers","name":"埃里克·萨默斯","alt":"https://movie.douban.com/celebrity/1368514/","id":"1368514"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1393770779.82.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1393770779.82.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1393770779.82.jpg"},"name_en":"Scott Rosenberg","name":"斯科特·罗森伯格","alt":"https://movie.douban.com/celebrity/1045248/","id":"1045248"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499666584.89.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499666584.89.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499666584.89.jpg"},"name_en":"Jeff Pinkner","name":"杰夫·皮克纳","alt":"https://movie.douban.com/celebrity/1339645/","id":"1339645"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1514172876.6.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1514172876.6.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1514172876.6.jpg"},"name_en":"Chris Van Allsburg","name":"克里斯·范·奥斯伯格","alt":"https://movie.douban.com/celebrity/1018801/","id":"1018801"}]
     * pubdates : ["2017-12-20(美国)","2018-01-12(中国大陆)"]
     * website :
     * tags : ["冒险","美国","喜剧","搞笑","奇幻","动作","科幻","2017","游戏","童年回忆"]
     * has_schedule : true
     * durations : ["119分钟"]
     * genres : ["动作","奇幻","冒险"]
     * trailers : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2510331260.jpg?1515665942","title":"中国预告片：丛林陷落版 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/226011/","small":"https://img3.doubanio.com/img/trailer/small/2510331260.jpg?1515665942","resource_url":"http://vt1.doubanio.com/201801161528/73aa1416f5b6d68b932e86add7c0cd44/view/movie/M/302260011.mp4","id":"226011"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2510226108.jpg?1515645669","title":"中国预告片：夺命闯关版 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/225966/","small":"https://img1.doubanio.com/img/trailer/small/2510226108.jpg?1515645669","resource_url":"http://vt1.doubanio.com/201801161528/eaab656c4265955c26edcea8cbfc8e0f/view/movie/M/302250966.mp4","id":"225966"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2510148980.jpg?","title":"中国预告片：神奇游戏版 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/225921/","small":"https://img3.doubanio.com/img/trailer/small/2510148980.jpg?","resource_url":"http://vt1.doubanio.com/201801161528/5dc20c66374d66e7f600c94b4b074f90/view/movie/M/302250921.mp4","id":"225921"},{"medium":"https://img3.doubanio.com/img/trailer/medium/2510059680.jpg?","title":"中国预告片：笑出猪叫版 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/225856/","small":"https://img3.doubanio.com/img/trailer/small/2510059680.jpg?","resource_url":"http://vt1.doubanio.com/201801161528/8b36ac8169775e64ee69acc88db3422e/view/movie/M/302250856.mp4","id":"225856"}]
     * trailer_urls : ["http://vt1.doubanio.com/201801161528/73aa1416f5b6d68b932e86add7c0cd44/view/movie/M/302260011.mp4","http://vt1.doubanio.com/201801161528/eaab656c4265955c26edcea8cbfc8e0f/view/movie/M/302250966.mp4","http://vt1.doubanio.com/201801161528/5dc20c66374d66e7f600c94b4b074f90/view/movie/M/302250921.mp4","http://vt1.doubanio.com/201801161528/8b36ac8169775e64ee69acc88db3422e/view/movie/M/302250856.mp4"]
     * has_ticket : true
     * bloopers : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2510407576.jpg?1515748832","title":"花絮：开战在即特辑 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/226076/","small":"https://img3.doubanio.com/img/trailer/small/2510407576.jpg?1515748832","resource_url":"http://vt1.doubanio.com/201801161528/46efa81681b69c50f251ff4141ec3389/view/movie/M/302260076.mp4","id":"226076"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2510023669.jpg?1515381679","title":"花絮：豆瓣电影专访巨石强森 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/225844/","small":"https://img1.doubanio.com/img/trailer/small/2510023669.jpg?1515381679","resource_url":"http://vt1.doubanio.com/201801161528/998bd768c7ed143785ee3471d7a8e33e/view/movie/M/302250844.mp4","id":"225844"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2507546887.jpg?","title":"花絮：颠覆变身特辑 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/225022/","small":"https://img1.doubanio.com/img/trailer/small/2507546887.jpg?","resource_url":"http://vt1.doubanio.com/201801161528/e0065c926277d2d99a5f06dd695f5a7c/view/movie/M/302250022.mp4","id":"225022"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2507373057.jpg?","title":"花絮：强森暴走特辑 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/224932/","small":"https://img1.doubanio.com/img/trailer/small/2507373057.jpg?","resource_url":"http://vt1.doubanio.com/201801161528/ca0fc1c3806f720686751762afbdeff4/view/movie/M/302240932.mp4","id":"224932"}]
     * clip_urls : ["http://vt1.doubanio.com/201801161528/9f12170bdb8a3f5936363a4592011975/view/movie/M/302260154.mp4","http://vt1.doubanio.com/201801161528/663bf177f48d81e45af2d947b1a99932/view/movie/M/302250644.mp4"]
     * casts : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg"},"name_en":"Dwayne Johnson","name":"道恩·强森","alt":"https://movie.douban.com/celebrity/1044707/","id":"1044707"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56350.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56350.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56350.jpg"},"name_en":"Kevin Hart","name":"凯文·哈特","alt":"https://movie.douban.com/celebrity/1286162/","id":"1286162"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35722.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35722.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p35722.jpg"},"name_en":"Jack Black","name":"杰克·布莱克","alt":"https://movie.douban.com/celebrity/1049492/","id":"1049492"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42663.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42663.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42663.jpg"},"name_en":"Karen Gillan","name":"凯伦·吉兰","alt":"https://movie.douban.com/celebrity/1036344/","id":"1036344"}]
     * countries : ["美国"]
     * mainland_pubdate : 2018-01-12
     * photos : [{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2474071535.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2474071535.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2474071535.jpg","alt":"https://movie.douban.com/photos/photo/2474071535/","id":"2474071535","icon":"https://img3.doubanio.com/view/photo/icon/public/p2474071535.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510141332.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2510141332.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510141332.jpg","alt":"https://movie.douban.com/photos/photo/2510141332/","id":"2510141332","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510141332.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2507542876.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2507542876.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2507542876.jpg","alt":"https://movie.douban.com/photos/photo/2507542876/","id":"2507542876","icon":"https://img3.doubanio.com/view/photo/icon/public/p2507542876.jpg"},{"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2507024339.jpg","image":"https://img1.doubanio.com/view/photo/photo/public/p2507024339.jpg","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2507024339.jpg","alt":"https://movie.douban.com/photos/photo/2507024339/","id":"2507024339","icon":"https://img1.doubanio.com/view/photo/icon/public/p2507024339.jpg"},{"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2473772218.jpg","image":"https://img1.doubanio.com/view/photo/photo/public/p2473772218.jpg","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2473772218.jpg","alt":"https://movie.douban.com/photos/photo/2473772218/","id":"2473772218","icon":"https://img1.doubanio.com/view/photo/icon/public/p2473772218.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510692903.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2510692903.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510692903.jpg","alt":"https://movie.douban.com/photos/photo/2510692903/","id":"2510692903","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510692903.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510692900.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2510692900.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510692900.jpg","alt":"https://movie.douban.com/photos/photo/2510692900/","id":"2510692900","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510692900.jpg"},{"thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2510692898.jpg","image":"https://img1.doubanio.com/view/photo/photo/public/p2510692898.jpg","cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2510692898.jpg","alt":"https://movie.douban.com/photos/photo/2510692898/","id":"2510692898","icon":"https://img1.doubanio.com/view/photo/icon/public/p2510692898.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510692890.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2510692890.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510692890.jpg","alt":"https://movie.douban.com/photos/photo/2510692890/","id":"2510692890","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510692890.jpg"},{"thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510211815.jpg","image":"https://img3.doubanio.com/view/photo/photo/public/p2510211815.jpg","cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510211815.jpg","alt":"https://movie.douban.com/photos/photo/2510211815/","id":"2510211815","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510211815.jpg"}]
     * summary : 《勇敢者游戏：决战丛林》讲述了四名性格迥异的高中生意外穿越到险象环生的勇敢者游戏中，变身成为与自身性格外貌截然不同的游戏角色。面对丛林猛兽的袭击和邪恶势力的追捕，四人必须在冒险家（道恩·强森 Dwayne Johnson 饰）的带领下，战胜重重危机，赢得游戏，才能获得重返现实的机会的故事。
     * clips : [{"medium":"https://img3.doubanio.com/img/trailer/medium/2510697053.jpg?","title":"片段：与蛇对视 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/226154/","small":"https://img3.doubanio.com/img/trailer/small/2510697053.jpg?","resource_url":"http://vt1.doubanio.com/201801161528/9f12170bdb8a3f5936363a4592011975/view/movie/M/302260154.mp4","id":"226154"},{"medium":"https://img1.doubanio.com/img/trailer/medium/2509544349.jpg?","title":"片段：河马吃人 (中文字幕)","subject_id":"26586766","alt":"https://movie.douban.com/trailer/225644/","small":"https://img1.doubanio.com/img/trailer/small/2509544349.jpg?","resource_url":"http://vt1.doubanio.com/201801161528/663bf177f48d81e45af2d947b1a99932/view/movie/M/302250644.mp4","id":"225644"}]
     * subtype : movie
     * directors : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg"},"name_en":"Jake Kasdan","name":"杰克·卡斯丹","alt":"https://movie.douban.com/celebrity/1040862/","id":"1040862"}]
     * comments_count : 16338.0
     * popular_reviews : [{"rating":{"max":5,"value":4,"min":0},"title":"《勇敢者游戏：决战丛林》：像这样没有毁经典的续作那可不多了。","subject_id":"26586766","author":{"uid":"162000558","avatar":"https://img3.doubanio.com/icon/u162000558-4.jpg","signature":"","alt":"https://www.douban.com/people/162000558/","id":"162000558","name":"架空"},"summary":"1995年，《勇敢者的游戏》上映。这部奇幻冒险电影，在土星奖上大放异彩，获七项提名两项大奖，并于1996年成功被大陆引进，荣升中国自95年起实行\u201c每年十部进口大片\u201d新政后的幸运儿，成为了广大80后珍贵的童年回...","alt":"https://movie.douban.com/review/9064923/","id":"9064923"},{"rating":{"max":5,"value":4,"min":0},"title":"《勇敢者的游戏：决战丛林》：二十年过去了，你还是这么好看","subject_id":"26586766","author":{"uid":"waking","avatar":"https://img3.doubanio.com/icon/u1282605-6.jpg","signature":"c'est la vie","alt":"https://www.douban.com/people/waking/","id":"1282605","name":"waking王小心"},"summary":"《勇敢者游戏》绝对是中国广大80后的共同回忆之一，因为那是一部当年引进的屈指可数的大片之一。那年我大概上高二，在电影院里看完了之后感到的震撼无以言表。看惯了国产地道战的我们从来没想过电影还可以这样拍...","alt":"https://movie.douban.com/review/9032617/","id":"9032617"},{"rating":{"max":5,"value":5,"min":0},"title":"jack black一生推！！","subject_id":"26586766","author":{"uid":"165934400","avatar":"https://img1.doubanio.com/icon/user_normal.jpg","signature":"","alt":"https://www.douban.com/people/165934400/","id":"165934400","name":"tempe婷"},"summary":"圣诞节前一天和老公在boon lay电影院看到这部电影，他以为是侏罗纪公园直接带我进去了，美其名曰带你看点恐怖的←_←结果从头笑到尾╮(╯▽╰)╭  每个人都有搞笑的戏份，但是杰克布莱克承包了大部分笑点，对我来...","alt":"https://movie.douban.com/review/9013956/","id":"9013956"},{"rating":{"max":5,"value":3,"min":0},"title":"【C+影评】新勇敢者游戏：从2017开始的异世界生活","subject_id":"26586766","author":{"uid":"CydenyLau","avatar":"https://img3.doubanio.com/icon/u127874432-2.jpg","signature":"I don't COMMENT. I CRITICIZE.","alt":"https://www.douban.com/people/CydenyLau/","id":"127874432","name":"CydenyLau"},"summary":"由于电脑特效水平的限制，90年代的商业电影在创作上更依赖于奇思妙想而非视觉奇观，这也使得一大批充满创意，情节生动，人物立体，节奏轻快的电影得以出现。这批电影重视不同既有类型之间的融合，尤其是基于角色...","alt":"https://movie.douban.com/review/9015231/","id":"9015231"},{"rating":{"max":5,"value":4,"min":0},"title":"幸好《勇敢者游戏：丛林决战》没毁我童年经典","subject_id":"26586766","author":{"uid":"1402913","avatar":"https://img3.doubanio.com/icon/u1402913-10.jpg","signature":"定居海外独立影评人","alt":"https://www.douban.com/people/1402913/","id":"1402913","name":"大聪看电影"},"summary":"不管你承不承认，人都是有怀旧情节的，你成为什么样的人，取决于你经历了怎样的人生。 大聪的童年时代，自然少不了一部《勇敢者的游戏》，这部小孩大人一起冒险的电影，真是百看不厌。 在当年互联网还没有到来的...","alt":"https://movie.douban.com/review/9066657/","id":"9066657"},{"rating":{"max":5,"value":4,"min":0},"title":"勇敢者的游戏","subject_id":"26586766","author":{"uid":"jie","avatar":"https://img3.doubanio.com/icon/u1003130-2.jpg","signature":"醉笑陪君三千场，不诉离伤。。。","alt":"https://www.douban.com/people/jie/","id":"1003130","name":"jie"},"summary":"勇敢者的游戏：决战丛林，2018年的第一场电影。 明摆着的结局，他们会回到现实，但每一步的闯关仍为他们揪着心，担心他们失去最后一条命。 游戏世界中，他们有不一样的外形，但他们仍是他们，但又附有了游戏角色...","alt":"https://movie.douban.com/review/9065519/","id":"9065519"},{"rating":{"max":5,"value":3,"min":0},"title":"一群并不完美的学生，通过游戏成为了更好的人。","subject_id":"26586766","author":{"uid":"lingrui1995","avatar":"https://img3.doubanio.com/icon/u63688511-15.jpg","signature":"FBI联邦屌插菊 搞基探员","alt":"https://www.douban.com/people/lingrui1995/","id":"63688511","name":"凌睿"},"summary":"在此之前，1995年和2005年还上映过2部《勇敢者的游戏》。 新版《勇敢者游戏》由道恩·强森、凯伦·吉兰等人主演，后者曾在《银河护卫队》系列中饰演\u201c星云\u201d。 电影讲述的是4名高中生在玩\u201c尤曼吉\u201d电子游戏的时...","alt":"https://movie.douban.com/review/9059674/","id":"9059674"},{"rating":{"max":5,"value":0,"min":0},"title":"巨石强森初吻吻了8分钟？No！是10分钟！","subject_id":"26586766","author":{"uid":"163662555","avatar":"https://img3.doubanio.com/icon/u163662555-2.jpg","signature":"","alt":"https://www.douban.com/people/163662555/","id":"163662555","name":"电影大爆炸"},"summary":"2018年一开年，中国人民的老朋友巨石强森就带着新片《勇敢者游戏》来到中国进行宣传，这也让他成为了新年首位来到中国的好莱坞明星。第三次来到中国的巨石强森显然已经对中国的宣传套路轻车熟路，不仅参与录制《...","alt":"https://movie.douban.com/review/9076003/","id":"9076003"},{"rating":{"max":5,"value":4,"min":0},"title":"\u201c贫穷\u201d并没有限制你的想象力","subject_id":"26586766","author":{"uid":"dreamfox","avatar":"https://img3.doubanio.com/icon/u2297669-6.jpg","signature":"公众号：dreamcrowfilm","alt":"https://www.douban.com/people/dreamfox/","id":"2297669","name":"乌鸦火堂"},"summary":"我记得我以前有过这样的幻想，那时候还是在上小学的时候，自己玩游戏玩爽了，晚上躺在被窝里做梦，幻想自己进入到游戏里，或者游戏角色都来到现实，跟俺一块叙叙旧。 这多年过去了，想想当年小时候自己也是挺弱的...","alt":"https://movie.douban.com/review/9063518/","id":"9063518"},{"rating":{"max":5,"value":5,"min":0},"title":"居然没有人讨论这部电影呈现的最有意思的时空悖论？","subject_id":"26586766","author":{"uid":"145656636","avatar":"https://img3.doubanio.com/icon/u145656636-1.jpg","signature":"","alt":"https://www.douban.com/people/145656636/","id":"145656636","name":"吴磊FRANK"},"summary":"首先来说说最近几年巨火的\"巨石强森\"（道恩·强森）。  Dwayne Johnson其实没有突破性的演技提升，这次的\"傻大个×领袖气场\"双重人格演技从头到尾都有《乌龙特工》既视感，而且连对手戏的演员都是一脉相承的Kevin...","alt":"https://movie.douban.com/review/9074200/","id":"9074200"}]
     * ratings_count : 34296.0
     * aka : ["野蛮游戏：疯狂丛林(台)","逃出魔幻纪：丛林挑机(港)","新勇敢者的游戏","勇敢者的游戏"]
     */

    private RatingBean rating;
    private double reviews_count;
    private double wish_count;
    private String original_title;
    private double collect_count;
    private ImagesBean images;
    private String douban_site;
    private String year;
    private String alt;
    private String id;
    private String mobile_url;
    private double photos_count;
    private String pubdate;
    private String title;
    private boolean has_video;
    private String share_url;
    private String schedule_url;
    private String website;
    private boolean has_schedule;
    private boolean has_ticket;
    private String mainland_pubdate;
    private String summary;
    private String subtype;
    private double comments_count;
    private double ratings_count;
    private List<?> videos;
    private List<String> blooper_urls;
    private List<PopularCommentsBean> popular_comments;
    private List<String> languages;
    private List<WritersBean> writers;
    private List<String> pubdates;
    private List<String> tags;
    private List<String> durations;
    private List<String> genres;
    private List<TrailersBean> trailers;
    private List<String> trailer_urls;
    private List<BloopersBean> bloopers;
    private List<String> clip_urls;
    private List<CastsBean> casts;
    private List<String> countries;
    private List<PhotosBean> photos;
    private List<ClipsBean> clips;
    private List<DirectorsBean> directors;
    private List<PopularReviewsBean> popular_reviews;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public double getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(double reviews_count) {
        this.reviews_count = reviews_count;
    }

    public double getWish_count() {
        return wish_count;
    }

    public void setWish_count(double wish_count) {
        this.wish_count = wish_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public double getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(double collect_count) {
        this.collect_count = collect_count;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public double getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(double photos_count) {
        this.photos_count = photos_count;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isHas_schedule() {
        return has_schedule;
    }

    public void setHas_schedule(boolean has_schedule) {
        this.has_schedule = has_schedule;
    }

    public boolean isHas_ticket() {
        return has_ticket;
    }

    public void setHas_ticket(boolean has_ticket) {
        this.has_ticket = has_ticket;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public double getComments_count() {
        return comments_count;
    }

    public void setComments_count(double comments_count) {
        this.comments_count = comments_count;
    }

    public double getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(double ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<?> getVideos() {
        return videos;
    }

    public void setVideos(List<?> videos) {
        this.videos = videos;
    }

    public List<String> getBlooper_urls() {
        return blooper_urls;
    }

    public void setBlooper_urls(List<String> blooper_urls) {
        this.blooper_urls = blooper_urls;
    }

    public List<PopularCommentsBean> getPopular_comments() {
        return popular_comments;
    }

    public void setPopular_comments(List<PopularCommentsBean> popular_comments) {
        this.popular_comments = popular_comments;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<WritersBean> getWriters() {
        return writers;
    }

    public void setWriters(List<WritersBean> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public List<String> getTrailer_urls() {
        return trailer_urls;
    }

    public void setTrailer_urls(List<String> trailer_urls) {
        this.trailer_urls = trailer_urls;
    }

    public List<BloopersBean> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<BloopersBean> bloopers) {
        this.bloopers = bloopers;
    }

    public List<String> getClip_urls() {
        return clip_urls;
    }

    public void setClip_urls(List<String> clip_urls) {
        this.clip_urls = clip_urls;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public List<ClipsBean> getClips() {
        return clips;
    }

    public void setClips(List<ClipsBean> clips) {
        this.clips = clips;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<PopularReviewsBean> getPopular_reviews() {
        return popular_reviews;
    }

    public void setPopular_reviews(List<PopularReviewsBean> popular_reviews) {
        this.popular_reviews = popular_reviews;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10.0
         * average : 7.2
         * details : {"1":63,"3":4158,"2":467,"5":1250,"4":4774}
         * stars : 40
         * min : 0.0
         */

        private double max;
        private double average;
        private DetailsBean details;
        private String stars;
        private double min;

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public DetailsBean getDetails() {
            return details;
        }

        public void setDetails(DetailsBean details) {
            this.details = details;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public static class DetailsBean {
            /**
             * 1 : 63.0
             * 3 : 4158.0
             * 2 : 467.0
             * 5 : 1250.0
             * 4 : 4774.0
             */

            @SerializedName("1")
            private double _$1;
            @SerializedName("3")
            private double _$3;
            @SerializedName("2")
            private double _$2;
            @SerializedName("5")
            private double _$5;
            @SerializedName("4")
            private double _$4;

            public double get_$1() {
                return _$1;
            }

            public void set_$1(double _$1) {
                this._$1 = _$1;
            }

            public double get_$3() {
                return _$3;
            }

            public void set_$3(double _$3) {
                this._$3 = _$3;
            }

            public double get_$2() {
                return _$2;
            }

            public void set_$2(double _$2) {
                this._$2 = _$2;
            }

            public double get_$5() {
                return _$5;
            }

            public void set_$5(double _$5) {
                this._$5 = _$5;
            }

            public double get_$4() {
                return _$4;
            }

            public void set_$4(double _$4) {
                this._$4 = _$4;
            }
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506258944.jpg
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506258944.jpg
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506258944.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class PopularCommentsBean {
        /**
         * rating : {"max":5,"value":4,"min":0}
         * useful_count : 43.0
         * author : {"uid":"zhecx","avatar":"https://img1.doubanio.com/icon/u2166920-17.jpg","signature":"好男人就是反复睡一个妞睡一辈子","alt":"https://www.douban.com/people/zhecx/","id":"2166920","name":"我就是树袋熊"}
         * subject_id : 26586766
         * content : 笑翻啊啊啊啊 哈哈哈哈哈哈哈 黑人太搞笑了 虽然最后感觉有点蛇尾 还是值得四星
         * created_at : 2017-12-17 00:15:23
         * id : 1287382501
         */

        private RatingBeanX rating;
        private double useful_count;
        private AuthorBean author;
        private String subject_id;
        private String content;
        private String created_at;
        private String id;

        public RatingBeanX getRating() {
            return rating;
        }

        public void setRating(RatingBeanX rating) {
            this.rating = rating;
        }

        public double getUseful_count() {
            return useful_count;
        }

        public void setUseful_count(double useful_count) {
            this.useful_count = useful_count;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanX {
            /**
             * max : 5.0
             * value : 4.0
             * min : 0.0
             */

            private double max;
            private double value;
            private double min;

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }
        }

        public static class AuthorBean {
            /**
             * uid : zhecx
             * avatar : https://img1.doubanio.com/icon/u2166920-17.jpg
             * signature : 好男人就是反复睡一个妞睡一辈子
             * alt : https://www.douban.com/people/zhecx/
             * id : 2166920
             * name : 我就是树袋熊
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class WritersBean {
        /**
         * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg"}
         * name_en : Chris McKenna
         * name : 克里斯·麦克纳
         * alt : https://movie.douban.com/celebrity/1331505/
         * id : 1331505
         */

        private AvatarsBean avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg
             * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg
             * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486948686.69.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class TrailersBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2510331260.jpg?1515665942
         * title : 中国预告片：丛林陷落版 (中文字幕)
         * subject_id : 26586766
         * alt : https://movie.douban.com/trailer/226011/
         * small : https://img3.doubanio.com/img/trailer/small/2510331260.jpg?1515665942
         * resource_url : http://vt1.doubanio.com/201801161528/73aa1416f5b6d68b932e86add7c0cd44/view/movie/M/302260011.mp4
         * id : 226011
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class BloopersBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2510407576.jpg?1515748832
         * title : 花絮：开战在即特辑 (中文字幕)
         * subject_id : 26586766
         * alt : https://movie.douban.com/trailer/226076/
         * small : https://img3.doubanio.com/img/trailer/small/2510407576.jpg?1515748832
         * resource_url : http://vt1.doubanio.com/201801161528/46efa81681b69c50f251ff4141ec3389/view/movie/M/302260076.mp4
         * id : 226076
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class CastsBean {
        /**
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg"}
         * name_en : Dwayne Johnson
         * name : 道恩·强森
         * alt : https://movie.douban.com/celebrity/1044707/
         * id : 1044707
         */

        private AvatarsBeanX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PhotosBean {
        /**
         * thumb : https://img3.doubanio.com/view/photo/thumb/public/p2474071535.jpg
         * image : https://img3.doubanio.com/view/photo/photo/public/p2474071535.jpg
         * cover : https://img3.doubanio.com/view/photo/albumcover/public/p2474071535.jpg
         * alt : https://movie.douban.com/photos/photo/2474071535/
         * id : 2474071535
         * icon : https://img3.doubanio.com/view/photo/icon/public/p2474071535.jpg
         */

        private String thumb;
        private String image;
        private String cover;
        private String alt;
        private String id;
        private String icon;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class ClipsBean {
        /**
         * medium : https://img3.doubanio.com/img/trailer/medium/2510697053.jpg?
         * title : 片段：与蛇对视 (中文字幕)
         * subject_id : 26586766
         * alt : https://movie.douban.com/trailer/226154/
         * small : https://img3.doubanio.com/img/trailer/small/2510697053.jpg?
         * resource_url : http://vt1.doubanio.com/201801161528/9f12170bdb8a3f5936363a4592011975/view/movie/M/302260154.mp4
         * id : 226154
         */

        private String medium;
        private String title;
        private String subject_id;
        private String alt;
        private String small;
        private String resource_url;
        private String id;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getResource_url() {
            return resource_url;
        }

        public void setResource_url(String resource_url) {
            this.resource_url = resource_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class DirectorsBean {
        /**
         * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg"}
         * name_en : Jake Kasdan
         * name : 杰克·卡斯丹
         * alt : https://movie.douban.com/celebrity/1040862/
         * id : 1040862
         */

        private AvatarsBeanXX avatars;
        private String name_en;
        private String name;
        private String alt;
        private String id;

        public AvatarsBeanXX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanXX avatars) {
            this.avatars = avatars;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanXX {
            /**
             * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg
             * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg
             * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1515078777.46.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class PopularReviewsBean {
        /**
         * rating : {"max":5,"value":4,"min":0}
         * title : 《勇敢者游戏：决战丛林》：像这样没有毁经典的续作那可不多了。
         * subject_id : 26586766
         * author : {"uid":"162000558","avatar":"https://img3.doubanio.com/icon/u162000558-4.jpg","signature":"","alt":"https://www.douban.com/people/162000558/","id":"162000558","name":"架空"}
         * summary : 1995年，《勇敢者的游戏》上映。这部奇幻冒险电影，在土星奖上大放异彩，获七项提名两项大奖，并于1996年成功被大陆引进，荣升中国自95年起实行“每年十部进口大片”新政后的幸运儿，成为了广大80后珍贵的童年回...
         * alt : https://movie.douban.com/review/9064923/
         * id : 9064923
         */

        private RatingBeanXX rating;
        private String title;
        private String subject_id;
        private AuthorBeanX author;
        private String summary;
        private String alt;
        private String id;

        public RatingBeanXX getRating() {
            return rating;
        }

        public void setRating(RatingBeanXX rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public AuthorBeanX getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBeanX author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class RatingBeanXX {
            /**
             * max : 5.0
             * value : 4.0
             * min : 0.0
             */

            private double max;
            private double value;
            private double min;

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }
        }

        public static class AuthorBeanX {
            /**
             * uid : 162000558
             * avatar : https://img3.doubanio.com/icon/u162000558-4.jpg
             * signature :
             * alt : https://www.douban.com/people/162000558/
             * id : 162000558
             * name : 架空
             */

            private String uid;
            private String avatar;
            private String signature;
            private String alt;
            private String id;
            private String name;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
