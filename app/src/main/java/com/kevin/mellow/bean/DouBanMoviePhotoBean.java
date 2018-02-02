package com.kevin.mellow.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/22.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanMoviePhotoBean {

    /**
     * count : 20.0
     * photos : [{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2504503486/","author":{"alt":"https://www.douban.com/people/122971558/","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","id":"122971558","name":"轮子","signature":"","uid":"122971558"},"comments_count":61,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2504503486.jpg","created_at":"2017-11-09 20:51:44","desc":"","icon":"https://img3.doubanio.com/view/photo/icon/public/p2504503486.jpg","id":"2504503486","image":"https://img3.doubanio.com/view/photo/photo/public/p2504503486.jpg","next_photo":"2504503475","photos_count":124,"position":116,"prev_photo":"2508925594","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2504503486.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2509530628/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":22,"cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2509530628.jpg","created_at":"2018-01-03 14:54:15","desc":"同学间的单纯情愫打动了少女心","icon":"https://img1.doubanio.com/view/photo/icon/public/p2509530628.jpg","id":"2509530628","image":"https://img1.doubanio.com/view/photo/photo/public/p2509530628.jpg","next_photo":"2509530622","photos_count":124,"position":107,"prev_photo":"2509530634","recs_count":0,"subject_id":"26942674","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2509530628.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2509623824/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":14,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2509623824.jpg","created_at":"2018-01-04 13:32:24","desc":"温柔的母亲是尹希娅生活里的亮光","icon":"https://img3.doubanio.com/view/photo/icon/public/p2509623824.jpg","id":"2509623824","image":"https://img3.doubanio.com/view/photo/photo/public/p2509623824.jpg","next_photo":"2509623817","photos_count":124,"position":100,"prev_photo":"2509623828","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2509623824.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510815517/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":11,"cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2510815517.jpg","created_at":"2018-01-16 18:53:04","desc":"","icon":"https://img1.doubanio.com/view/photo/icon/public/p2510815517.jpg","id":"2510815517","image":"https://img1.doubanio.com/view/photo/photo/public/p2510815517.jpg","next_photo":"2510815515","photos_count":124,"position":71,"prev_photo":"2510815518","recs_count":0,"subject_id":"26942674","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2510815517.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510984789/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":4,"cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2510984789.jpg","created_at":"2018-01-18 16:45:28","desc":"尹希娅获得音乐人夏克提的支持和指引","icon":"https://img1.doubanio.com/view/photo/icon/public/p2510984789.jpg","id":"2510984789","image":"https://img1.doubanio.com/view/photo/photo/public/p2510984789.jpg","next_photo":"2510984787","photos_count":124,"position":53,"prev_photo":"2511051878","recs_count":0,"subject_id":"26942674","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2510984789.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2504503405/","author":{"alt":"https://www.douban.com/people/122971558/","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","id":"122971558","name":"轮子","signature":"","uid":"122971558"},"comments_count":18,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2504503405.jpg","created_at":"2017-11-09 20:51:08","desc":"","icon":"https://img3.doubanio.com/view/photo/icon/public/p2504503405.jpg","id":"2504503405","image":"https://img3.doubanio.com/view/photo/photo/public/p2504503405.jpg","next_photo":"2504503393","photos_count":124,"position":122,"prev_photo":"2504503417","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2504503405.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510695048/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":13,"cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2510695048.jpg","created_at":"2018-01-15 14:19:43","desc":"尹希娅和家人、夏克提紧张等待颁奖结果","icon":"https://img1.doubanio.com/view/photo/icon/public/p2510695048.jpg","id":"2510695048","image":"https://img1.doubanio.com/view/photo/photo/public/p2510695048.jpg","next_photo":"2510695047","photos_count":124,"position":74,"prev_photo":"2510815512","recs_count":0,"subject_id":"26942674","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2510695048.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2504503422/","author":{"alt":"https://www.douban.com/people/122971558/","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","id":"122971558","name":"轮子","signature":"","uid":"122971558"},"comments_count":18,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2504503422.jpg","created_at":"2017-11-09 20:51:19","desc":"","icon":"https://img3.doubanio.com/view/photo/icon/public/p2504503422.jpg","id":"2504503422","image":"https://img3.doubanio.com/view/photo/photo/public/p2504503422.jpg","next_photo":"2504503417","photos_count":124,"position":120,"prev_photo":"2504503426","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2504503422.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510815515/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":6,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510815515.jpg","created_at":"2018-01-16 18:53:02","desc":"母女俩相互支持鼓励的温情时刻","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510815515.jpg","id":"2510815515","image":"https://img3.doubanio.com/view/photo/photo/public/p2510815515.jpg","next_photo":"2510815512","photos_count":124,"position":72,"prev_photo":"2510815517","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510815515.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2509530634/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":6,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2509530634.jpg","created_at":"2018-01-03 14:54:19","desc":"音乐人夏克提帮尹希娅打开梦想","icon":"https://img3.doubanio.com/view/photo/icon/public/p2509530634.jpg","id":"2509530634","image":"https://img3.doubanio.com/view/photo/photo/public/p2509530634.jpg","next_photo":"2509530628","photos_count":124,"position":106,"prev_photo":"2509530637","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2509530634.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2509623830/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":8,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2509623830.jpg","created_at":"2018-01-04 13:32:30","desc":"尹希娅与母亲弟弟的家庭欢乐时光","icon":"https://img3.doubanio.com/view/photo/icon/public/p2509623830.jpg","id":"2509623830","image":"https://img3.doubanio.com/view/photo/photo/public/p2509623830.jpg","next_photo":"2509623828","photos_count":124,"position":98,"prev_photo":"2509723461","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2509623830.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2504503417/","author":{"alt":"https://www.douban.com/people/122971558/","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","id":"122971558","name":"轮子","signature":"","uid":"122971558"},"comments_count":3,"cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2504503417.jpg","created_at":"2017-11-09 20:51:18","desc":"","icon":"https://img1.doubanio.com/view/photo/icon/public/p2504503417.jpg","id":"2504503417","image":"https://img1.doubanio.com/view/photo/photo/public/p2504503417.jpg","next_photo":"2504503405","photos_count":124,"position":121,"prev_photo":"2504503422","recs_count":0,"subject_id":"26942674","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2504503417.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2511051880/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":6,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2511051880.jpg","created_at":"2018-01-19 12:37:01","desc":"","icon":"https://img3.doubanio.com/view/photo/icon/public/p2511051880.jpg","id":"2511051880","image":"https://img3.doubanio.com/view/photo/photo/public/p2511051880.jpg","next_photo":"2511051878","photos_count":124,"position":51,"prev_photo":"2511051883","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2511051880.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510984787/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":4,"cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2510984787.jpg","created_at":"2018-01-18 16:45:26","desc":"尹希娅等着梦想发光的时刻","icon":"https://img1.doubanio.com/view/photo/icon/public/p2510984787.jpg","id":"2510984787","image":"https://img1.doubanio.com/view/photo/photo/public/p2510984787.jpg","next_photo":"2510984781","photos_count":124,"position":54,"prev_photo":"2510984789","recs_count":0,"subject_id":"26942674","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2510984787.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510984779/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":5,"cover":"https://img1.doubanio.com/view/photo/albumcover/public/p2510984779.jpg","created_at":"2018-01-18 16:45:20","desc":"被父亲暴力对待的尹希娅","icon":"https://img1.doubanio.com/view/photo/icon/public/p2510984779.jpg","id":"2510984779","image":"https://img1.doubanio.com/view/photo/photo/public/p2510984779.jpg","next_photo":"2510876256","photos_count":124,"position":56,"prev_photo":"2510984781","recs_count":1,"subject_id":"26942674","thumb":"https://img1.doubanio.com/view/photo/thumb/public/p2510984779.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510695032/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":6,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510695032.jpg","created_at":"2018-01-15 14:19:31","desc":"毒舌评委音乐人夏克提","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510695032.jpg","id":"2510695032","image":"https://img3.doubanio.com/view/photo/photo/public/p2510695032.jpg","next_photo":"2510404755","photos_count":124,"position":82,"prev_photo":"2510695033","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510695032.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510211982/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":0,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510211982.jpg","created_at":"2018-01-10 12:50:31","desc":"音乐人夏克提·库马尔（阿米尔·汗饰演）","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510211982.jpg","id":"2510211982","image":"https://img3.doubanio.com/view/photo/photo/public/p2510211982.jpg","next_photo":"2510056456","photos_count":124,"position":90,"prev_photo":"2510211988","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510211982.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2509530643/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":5,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2509530643.jpg","created_at":"2018-01-03 14:54:25","desc":"尹希娅在录音棚忘我歌唱","icon":"https://img3.doubanio.com/view/photo/icon/public/p2509530643.jpg","id":"2509530643","image":"https://img3.doubanio.com/view/photo/photo/public/p2509530643.jpg","next_photo":"2509530638","photos_count":124,"position":103,"prev_photo":"2509623815","recs_count":1,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2509530643.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2508925601/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":1,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2508925601.jpg","created_at":"2017-12-28 15:04:31","desc":"尹希娅望向火车窗外的天空","icon":"https://img3.doubanio.com/view/photo/icon/public/p2508925601.jpg","id":"2508925601","image":"https://img3.doubanio.com/view/photo/photo/public/p2508925601.jpg","next_photo":"2508925596","photos_count":124,"position":113,"prev_photo":"2508925604","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2508925601.jpg"},{"album_id":"1653612635","album_title":"Secret Superstar(26942674)","album_url":"https://movie.douban.com/subject/26942674/photos","alt":"https://movie.douban.com/photos/photo/2510984781/","author":{"alt":"https://www.douban.com/people/146443262/","avatar":"https://img3.doubanio.com/icon/u146443262-4.jpg","id":"146443262","name":"你看看","signature":"❤","uid":"146443262"},"comments_count":0,"cover":"https://img3.doubanio.com/view/photo/albumcover/public/p2510984781.jpg","created_at":"2018-01-18 16:45:22","desc":"看似温馨的家庭时光其实暗藏冲突","icon":"https://img3.doubanio.com/view/photo/icon/public/p2510984781.jpg","id":"2510984781","image":"https://img3.doubanio.com/view/photo/photo/public/p2510984781.jpg","next_photo":"2510984779","photos_count":124,"position":55,"prev_photo":"2510984787","recs_count":0,"subject_id":"26942674","thumb":"https://img3.doubanio.com/view/photo/thumb/public/p2510984781.jpg"}]
     * start : 0.0
     * subject : {"alt":"https://movie.douban.com/subject/26942674/","casts":[{"alt":"https://movie.douban.com/celebrity/1373292/","avatars":{"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg"},"id":"1373292","name":"塞伊拉·沃西","name_en":"Zaira Wasim"},{"alt":"https://movie.douban.com/celebrity/1383897/","avatars":{"large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510229457.27.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510229457.27.jpg","small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510229457.27.jpg"},"id":"1383897","name":"梅·维贾","name_en":"Meher Vij"},{"alt":"https://movie.douban.com/celebrity/1031931/","avatars":{"large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13628.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13628.jpg","small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13628.jpg"},"id":"1031931","name":"阿米尔·汗","name_en":"Aamir Khan"}],"collect_count":45433,"directors":[{"alt":"https://movie.douban.com/celebrity/1379532/","avatars":{"large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg","small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg"},"id":"1379532","name":"阿德瓦·香登","name_en":"Advait Chandan"}],"durations":["150分钟"],"genres":["剧情","音乐"],"has_video":false,"id":"26942674","images":{"large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg","small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg"},"mainland_pubdate":"2018-01-19","original_title":"Secret Superstar","pubdates":["2017-10-18(印度)","2018-01-19(中国大陆)"],"rating":{"average":8.1,"details":{"1":60,"2":310,"3":2196,"4":4966,"5":3485},"max":10,"min":0,"stars":"40"},"subtype":"movie","title":"神秘巨星","year":"2017"}
     * total : 45.0
     */

    private double count;
    private double start;
    private SubjectBean subject;
    private double total;
    private List<PhotosBean> photos;

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public SubjectBean getSubject() {
        return subject;
    }

    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<PhotosBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBean> photos) {
        this.photos = photos;
    }

    public static class SubjectBean {
        /**
         * alt : https://movie.douban.com/subject/26942674/
         * casts : [{"alt":"https://movie.douban.com/celebrity/1373292/","avatars":{"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg"},"id":"1373292","name":"塞伊拉·沃西","name_en":"Zaira Wasim"},{"alt":"https://movie.douban.com/celebrity/1383897/","avatars":{"large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510229457.27.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510229457.27.jpg","small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510229457.27.jpg"},"id":"1383897","name":"梅·维贾","name_en":"Meher Vij"},{"alt":"https://movie.douban.com/celebrity/1031931/","avatars":{"large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13628.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13628.jpg","small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13628.jpg"},"id":"1031931","name":"阿米尔·汗","name_en":"Aamir Khan"}]
         * collect_count : 45433.0
         * directors : [{"alt":"https://movie.douban.com/celebrity/1379532/","avatars":{"large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg","small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg"},"id":"1379532","name":"阿德瓦·香登","name_en":"Advait Chandan"}]
         * durations : ["150分钟"]
         * genres : ["剧情","音乐"]
         * has_video : false
         * id : 26942674
         * images : {"large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg","small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg"}
         * mainland_pubdate : 2018-01-19
         * original_title : Secret Superstar
         * pubdates : ["2017-10-18(印度)","2018-01-19(中国大陆)"]
         * rating : {"average":8.1,"details":{"1":60,"2":310,"3":2196,"4":4966,"5":3485},"max":10,"min":0,"stars":"40"}
         * subtype : movie
         * title : 神秘巨星
         * year : 2017
         */

        private String alt;
        private double collect_count;
        private boolean has_video;
        private String id;
        private ImagesBean images;
        private String mainland_pubdate;
        private String original_title;
        private RatingBean rating;
        private String subtype;
        private String title;
        private String year;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;
        private List<String> durations;
        private List<String> genres;
        private List<String> pubdates;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public double getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(double collect_count) {
            this.collect_count = collect_count;
        }

        public boolean isHas_video() {
            return has_video;
        }

        public void setHas_video(boolean has_video) {
            this.has_video = has_video;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getMainland_pubdate() {
            return mainland_pubdate;
        }

        public void setMainland_pubdate(String mainland_pubdate) {
            this.mainland_pubdate = mainland_pubdate;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
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

        public List<String> getPubdates() {
            return pubdates;
        }

        public void setPubdates(List<String> pubdates) {
            this.pubdates = pubdates;
        }

        public static class ImagesBean {
            /**
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508925590.jpg
             */

            private String large;
            private String medium;
            private String small;

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

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }
        }

        public static class RatingBean {
            /**
             * average : 8.1
             * details : {"1":60,"2":310,"3":2196,"4":4966,"5":3485}
             * max : 10.0
             * min : 0.0
             * stars : 40
             */

            private double average;
            private DetailsBean details;
            private double max;
            private double min;
            private String stars;

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

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public static class DetailsBean {
                /**
                 * 1 : 60.0
                 * 2 : 310.0
                 * 3 : 2196.0
                 * 4 : 4966.0
                 * 5 : 3485.0
                 */

                @SerializedName("1")
                private double _$1;
                @SerializedName("2")
                private double _$2;
                @SerializedName("3")
                private double _$3;
                @SerializedName("4")
                private double _$4;
                @SerializedName("5")
                private double _$5;

                public double get_$1() {
                    return _$1;
                }

                public void set_$1(double _$1) {
                    this._$1 = _$1;
                }

                public double get_$2() {
                    return _$2;
                }

                public void set_$2(double _$2) {
                    this._$2 = _$2;
                }

                public double get_$3() {
                    return _$3;
                }

                public void set_$3(double _$3) {
                    this._$3 = _$3;
                }

                public double get_$4() {
                    return _$4;
                }

                public void set_$4(double _$4) {
                    this._$4 = _$4;
                }

                public double get_$5() {
                    return _$5;
                }

                public void set_$5(double _$5) {
                    this._$5 = _$5;
                }
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1373292/
             * avatars : {"large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg","small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg"}
             * id : 1373292
             * name : 塞伊拉·沃西
             * name_en : Zaira Wasim
             */

            private String alt;
            private AvatarsBean avatars;
            private String id;
            private String name;
            private String name_en;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
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

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public static class AvatarsBean {
                /**
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494080264.12.jpg
                 */

                private String large;
                private String medium;
                private String small;

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

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1379532/
             * avatars : {"large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg","small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg"}
             * id : 1379532
             * name : 阿德瓦·香登
             * name_en : Advait Chandan
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String id;
            private String name;
            private String name_en;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
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

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public static class AvatarsBeanX {
                /**
                 * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg
                 * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg
                 * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509423054.09.jpg
                 */

                private String large;
                private String medium;
                private String small;

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

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }
            }
        }
    }

    public static class PhotosBean {
        /**
         * album_id : 1653612635
         * album_title : Secret Superstar(26942674)
         * album_url : https://movie.douban.com/subject/26942674/photos
         * alt : https://movie.douban.com/photos/photo/2504503486/
         * author : {"alt":"https://www.douban.com/people/122971558/","avatar":"https://img3.doubanio.com/icon/u122971558-2.jpg","id":"122971558","name":"轮子","signature":"","uid":"122971558"}
         * comments_count : 61.0
         * cover : https://img3.doubanio.com/view/photo/albumcover/public/p2504503486.jpg
         * created_at : 2017-11-09 20:51:44
         * desc :
         * icon : https://img3.doubanio.com/view/photo/icon/public/p2504503486.jpg
         * id : 2504503486
         * image : https://img3.doubanio.com/view/photo/photo/public/p2504503486.jpg
         * next_photo : 2504503475
         * photos_count : 124.0
         * position : 116.0
         * prev_photo : 2508925594
         * recs_count : 0.0
         * subject_id : 26942674
         * thumb : https://img3.doubanio.com/view/photo/thumb/public/p2504503486.jpg
         */

        private String album_id;
        private String album_title;
        private String album_url;
        private String alt;
        private AuthorBean author;
        private double comments_count;
        private String cover;
        private String created_at;
        private String desc;
        private String icon;
        private String id;
        private String image;
        private String next_photo;
        private double photos_count;
        private double position;
        private String prev_photo;
        private double recs_count;
        private String subject_id;
        private String thumb;

        public String getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(String album_id) {
            this.album_id = album_id;
        }

        public String getAlbum_title() {
            return album_title;
        }

        public void setAlbum_title(String album_title) {
            this.album_title = album_title;
        }

        public String getAlbum_url() {
            return album_url;
        }

        public void setAlbum_url(String album_url) {
            this.album_url = album_url;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public double getComments_count() {
            return comments_count;
        }

        public void setComments_count(double comments_count) {
            this.comments_count = comments_count;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNext_photo() {
            return next_photo;
        }

        public void setNext_photo(String next_photo) {
            this.next_photo = next_photo;
        }

        public double getPhotos_count() {
            return photos_count;
        }

        public void setPhotos_count(double photos_count) {
            this.photos_count = photos_count;
        }

        public double getPosition() {
            return position;
        }

        public void setPosition(double position) {
            this.position = position;
        }

        public String getPrev_photo() {
            return prev_photo;
        }

        public void setPrev_photo(String prev_photo) {
            this.prev_photo = prev_photo;
        }

        public double getRecs_count() {
            return recs_count;
        }

        public void setRecs_count(double recs_count) {
            this.recs_count = recs_count;
        }

        public String getSubject_id() {
            return subject_id;
        }

        public void setSubject_id(String subject_id) {
            this.subject_id = subject_id;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public static class AuthorBean {
            /**
             * alt : https://www.douban.com/people/122971558/
             * avatar : https://img3.doubanio.com/icon/u122971558-2.jpg
             * id : 122971558
             * name : 轮子
             * signature :
             * uid : 122971558
             */

            private String alt;
            private String avatar;
            private String id;
            private String name;
            private String signature;
            private String uid;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
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

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }
    }
}
