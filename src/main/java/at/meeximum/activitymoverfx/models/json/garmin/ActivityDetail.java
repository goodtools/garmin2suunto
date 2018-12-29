//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.garmin;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Data
public class ActivityDetail {

    @SerializedName("activityId")
    String activityId;
    @SerializedName("detailsAvailable")
    boolean detailsAvailable;
    @SerializedName("measurementCount")
    int measurementCount;
    @SerializedName("metricsCount")
    int metricsCount;
    @SerializedName("metricDescriptors")
    List<MetricDescriptor> metricDescriptors;
    @SerializedName("activityDetailMetrics")
    List<ActivityDetailMetric> activityDetailMetrics;
    @SerializedName("geoPolylineDTO")
    GeoPolylineDTO geoPolylineDTO;

    @Data
    public static class ActivityDetailMetric implements Serializable {

        private Double[] metrics;

        public float getCadence(MetricIndex index) {
            return getFloat(index.getRunCadence());
        }

        public float getRunningCadence(MetricIndex index) {
            return getFloat(index.getDoubleCadence());
        }

        public float getSpeed(MetricIndex index) {
            return getFloat(index.getSpeed());
        }

        public int getDistance(MetricIndex index) {
            return getInt(index.getDistance());
        }

        public int getHeartRate(MetricIndex index) {
            return getInt(index.getHearRate());
        }

        public String getLocalTime(MetricIndex index) {
            int i = index.getTime();
            if (i < 0) {
                return null;
            }
            if (metrics[i] == null) {
                return null;
            }
            Long time = metrics[i].longValue();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.of("Asia/Shanghai"));
            return localDateTime.toString();
        }

        private int getInt(int i) {
            return Float.valueOf(getFloat(i)).intValue();
        }

        private float getFloat(int i) {
            if (i < 0 || null == metrics[i]) {
                return 0.0F;
            }
            return metrics[i].floatValue();
        }
    }

    @Data
    public static class MetricDescriptor implements Serializable {
        private int metricsIndex;
        private String key;
        private Unit unit;
    }

    @Data
    public static class Unit {
        private String id;
        private String key;
        private double factor;
    }

    @Data
    public static class GeoPolylineDTO implements Serializable {
        List<Track> polyline;
    }

    @Data
    public static class Track implements Serializable {
        Double lat;
        Double lon;
        Float altitude;
        Double speed;
        Long time;

        public String getTimeLocale() {
            if (null == time || 0 == time) {
                return null;
            }
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.of("Asia/Shanghai"));
            return localDateTime.toString();
        }
    }

    @Data
    public static class MetricIndex {

        private int runCadence = -1;
        private int doubleCadence = -1;
        private int speed = -1;
        private int time = -1;
        private int hearRate = -1;
        private int distance = -1;

        public MetricIndex(List<ActivityDetail.MetricDescriptor> descriptors) {
            if (null == descriptors) {
                return;
            }
            for (int i = 0; i < descriptors.size(); i++) {
                ActivityDetail.MetricDescriptor descriptor = descriptors.get(i);
                switch (descriptor.getKey()) {
                    case "directRunCadence":
                        runCadence = descriptor.getMetricsIndex();
                        break;
                    case "directHeartRate":
                        hearRate = descriptor.getMetricsIndex();
                        break;
                    case "directSpeed":
                        speed = descriptor.getMetricsIndex();
                        break;
                    case "directDoubleCadence":
                        doubleCadence = descriptor.getMetricsIndex();
                        break;
                    case "directTimestamp":
                        time = descriptor.getMetricsIndex();
                        break;
                    case "sumDistance":
                        distance = descriptor.getMetricsIndex();
                        break;
                    default:
                        break;
                }

            }
        }
    }
}
