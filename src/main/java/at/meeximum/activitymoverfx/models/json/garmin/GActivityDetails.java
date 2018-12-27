//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.garmin;

import at.meeximum.activitymoverfx.utils.DateUtils;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

public class GActivityDetails {
    @SerializedName("activityId")
    String activityId;
    @SerializedName("isDetailsAvailable")
    boolean detailsAvailable;
    @SerializedName("measurementCount")
    int measurementCount;
    @SerializedName("metricsCount")
    int metricsCount;
    @SerializedName("measurements")
    Collection<Measurement> measurements = new ArrayList();
    @SerializedName("metrics")
    ArrayList<Metrics> metrics = new ArrayList();
    @XmlTransient
    private Map<String, Measurement> measurementsMap;

    public GActivityDetails() {
    }

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String var1) {
        this.activityId = var1;
    }

    public boolean isDetailsAvailable() {
        return this.detailsAvailable;
    }

    public void setDetailsAvailable(boolean var1) {
        this.detailsAvailable = var1;
    }

    public int getMeasurementCount() {
        return this.measurementCount;
    }

    public void setMeasurementCount(int var1) {
        this.measurementCount = var1;
    }

    public int getMetricsCount() {
        return this.metricsCount;
    }

    public void setMetricsCount(int var1) {
        this.metricsCount = var1;
    }

    public Collection<Measurement> getMeasurements() {
        return this.measurements;
    }

    public void setMeasurements(Collection<Measurement> var1) {
        this.measurements = var1;
    }

    public ArrayList<Metrics> getMetrics() {
        return this.metrics;
    }

    public void setMetrics(ArrayList<Metrics> var1) {
        this.metrics = var1;
    }

    public String getTimeStamp(int var1) {
        int var2 = this.getMeasurementIdx("directTimestamp");
        if (var2 < 0) {
            return "";
        } else {
            Double var3 = ((GActivityDetails.Metrics)this.metrics.get(var1)).getMetrics()[var2];
            Date var4 = new Date(var3.longValue());
            return DateUtils.formatDateTimeForMoveWithMS(var4);
        }
    }

    public Long getTimeStampMS(int var1) {
        int var2 = this.getMeasurementIdx("directTimestamp");
        if (var2 < 0) {
            return null;
        } else {
            Double var3 = ((GActivityDetails.Metrics)this.metrics.get(var1)).getMetrics()[var2];
            return var3.longValue();
        }
    }

    public Double getLatitude(int var1) {
        return this.getMetricValue("directLatitude", var1);
    }

    public Double getLongitude(int var1) {
        return this.getMetricValue("directLongitude", var1);
    }

    public Double getRunCadence(int var1) {
        return this.getMetricValue("directRunCadence", var1);
    }

    public Double getBikeCadence(int var1) {
        return this.getMetricValue("directBikeCadence", var1);
    }

    public Double getPace(int var1) {
        return this.getMetricValue("directPace", var1);
    }

    public Double getSpeedInMPS(int var1) {
        Double var2 = this.getMetricValue("directSpeed", var1);
        if (var2 != null) {
            String var3 = this.getMetricUnit("directSpeed", var1);
            if (StringUtils.startsWith(var3, "m")) {
                var2 = var2 * 1.6093440055847168D;
            }

            if (StringUtils.startsWith(var3, "hyd")) {
                var2 = var2 * 0.09143999963998795D;
            }

            if (StringUtils.endsWith(var3, "h")) {
                var2 = var2 / 3.5999999046325684D;
            }
        }

        return var2;
    }

    public Double getElevationInM(int var1) {
        Double var2 = this.getMetricValue("directElevation", var1);
        if (var2 != null) {
            String var3 = this.getMetricUnit("directElevation", var1);
            if (!"meter".equals(var3)) {
                var2 = var2 * 0.30480000376701355D;
            }
        }

        return var2;
    }

    public Double getHeartRate(int var1) {
        return this.getMetricValue("directHeartRate", var1);
    }

    public Double getAirTemperature(int var1) {
        Double var2 = this.getMetricValue("directAirTemperature", var1);
        if (var2 != null) {
            String var3 = this.getMetricUnit("directAirTemperature", var1);
            if ("fahrenheit".equalsIgnoreCase(var3)) {
                var2 = (var2 - 32.0D) * 5.0D / 9.0D;
            }
        }

        return var2;
    }

    public Double getDistanceInKM(int var1) {
        Double var2 = this.getMetricValue("sumDistance", var1);
        if (var2 != null) {
            String var3 = this.getMetricUnit("sumDistance", var1);
            if (StringUtils.startsWith(var3, "mile")) {
                var2 = var2 * 1.6093440055847168D;
            }

            if (StringUtils.startsWith(var3, "yard")) {
                var2 = var2 * 9.14399977773428E-4D;
            }

            if (StringUtils.startsWith(var3, "meter")) {
                var2 = var2 / 1000.0D;
            }
        }

        return var2;
    }

    public Double getPower(int var1) {
        return this.getMetricValue("directPower", var1);
    }

    private Double getMetricValue(String var1, int var2) {
        int var3 = this.getMeasurementIdx(var1);
        return var3 < 0 ? null : ((GActivityDetails.Metrics)this.metrics.get(var2)).getMetrics()[var3];
    }

    private String getMetricUnit(String var1, int var2) {
        return this.getMeasurementUnit(var1);
    }

    public void initMeasurementMap() {
        this.measurementsMap = new HashMap(this.measurementCount);
        Iterator var1 = this.measurements.iterator();

        while(var1.hasNext()) {
            GActivityDetails.Measurement var2 = (GActivityDetails.Measurement)var1.next();
            this.measurementsMap.put(var2.getKey().toLowerCase(), var2);
        }

    }

    private int getMeasurementIdx(String var1) {
        if (this.measurementsMap == null) {
            this.initMeasurementMap();
        }

        GActivityDetails.Measurement var2 = (GActivityDetails.Measurement)this.measurementsMap.get(var1.toLowerCase());
        return var2 == null ? -1 : var2.getMetricsIndex();
    }

    private String getMeasurementUnit(String var1) {
        if (this.measurementsMap == null) {
            this.initMeasurementMap();
        }

        GActivityDetails.Measurement var2 = (GActivityDetails.Measurement)this.measurementsMap.get(var1.toLowerCase());
        return var2 == null ? null : var2.getUnit();
    }

    public String toString() {
        return "Activity (details): " + this.getActivityId();
    }

    private class Metrics {
        @SerializedName("metrics")
        Double[] metrics;

        private Metrics() {
        }

        public Double[] getMetrics() {
            return this.metrics;
        }

        public void setMetrics(Double[] var1) {
            this.metrics = var1;
        }
    }

    private class Measurement {
        @SerializedName("metricsIndex")
        int metricsIndex;
        @SerializedName("key")
        String key;
        @SerializedName("display")
        String display;
        @SerializedName("unit")
        String unit;
        @SerializedName("unitAbbr")
        String unitAbbr;
        @SerializedName("unitDisplay")
        String unitDisplay;

        private Measurement() {
        }

        public int getMetricsIndex() {
            return this.metricsIndex;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String var1) {
            this.key = var1;
        }

        public String getDisplay() {
            return this.display;
        }

        public void setDisplay(String var1) {
            this.display = var1;
        }

        public String getUnit() {
            return this.unit;
        }

        public void setUnit(String var1) {
            this.unit = var1;
        }

        public String getUnitAbbr() {
            return this.unitAbbr;
        }

        public void setUnitAbbr(String var1) {
            this.unitAbbr = var1;
        }

        public String getUnitDisplay() {
            return this.unitDisplay;
        }

        public void setUnitDisplay(String var1) {
            this.unitDisplay = var1;
        }
    }
}
