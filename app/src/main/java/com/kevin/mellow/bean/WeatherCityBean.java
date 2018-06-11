package com.kevin.mellow.bean;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/8.
 * <h3>
 * Describe:
 * <h3/>
 */
public class WeatherCityBean {


    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : [{"cid":"CN101020100","location":"上海","parent_city":"上海","admin_area":"上海",
         * "cnty":"中国","lat":"31.23170662","lon":"121.47264099","tz":"+8.00","type":"city"},
         * {"cid":"CN101020900","location":"松江","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.03046989","lon":"121.22354126","tz":"+8.00","type":"city"},
         * {"cid":"CN101020200","location":"闵行","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.1116581","lon":"121.37596893","tz":"+8.00","type":"city"},
         * {"cid":"CN101020400","location":"黄浦","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.22277069","lon":"121.4903183","tz":"+8.00","type":"city"},
         * {"cid":"CN101021400","location":"静安","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.22900391","lon":"121.44822693","tz":"+8.00","type":"city"},
         * {"cid":"CN101020800","location":"青浦","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.15120888","lon":"121.11302185","tz":"+8.00","type":"city"},
         * {"cid":"CN101021200","location":"徐汇","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.1799736","lon":"121.43752289","tz":"+8.00","type":"city"},
         * {"cid":"CN101021100","location":"崇明","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.6269455","lon":"121.39751434","tz":"+8.00","type":"city"},
         * {"cid":"CN101021000","location":"奉贤","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"30.91234589","lon":"121.45847321","tz":"+8.00","type":"city"},
         * {"cid":"CN101020300","location":"宝山","parent_city":"上海","admin_area":"上海","cnty":"中国",
         * "lat":"31.39889526","lon":"121.48993683","tz":"+8.00","type":"city"}]
         * status : ok
         */

        private String status;
        private List<BasicBean> basic;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<BasicBean> getBasic() {
            return basic;
        }

        public void setBasic(List<BasicBean> basic) {
            this.basic = basic;
        }

        public static class BasicBean {
            /**
             * cid : CN101020100
             * location : 上海
             * parent_city : 上海
             * admin_area : 上海
             * cnty : 中国
             * lat : 31.23170662
             * lon : 121.47264099
             * tz : +8.00
             * type : city
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;
            private String type;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
