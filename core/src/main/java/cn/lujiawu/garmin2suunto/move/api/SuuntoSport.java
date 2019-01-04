//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.move.api;

public enum SuuntoSport {

    NOT_SPECIFIED_SPORT(1),
    MULTISPORT(2),
    RUN(3),
    CYCLING(4),
    MOUNTAIN_BIKING(5),
    SWIMMING(6),
    SKATING(8),
    AEROBICS(9),
    YOGA_PILATES(10),
    TREKKING(11),
    WALKING(12),
    SAILING(13),
    KAYAKING(14),
    ROWING(15),
    CLIMBING(16),
    INDOOR_CYCLING(17),
    CIRCUIT_TRAINING(18),
    TRIATHLON(19),
    ALPINE_SKIING(20),
    SNOWBOARDING(21),
    CROSSCOUNTRY_SKIING(22),
    WEIGHT_TRAINING(23),
    BASKETBALL(24),
    SOCCER(25),
    ICE_HOCKEY(26),
    VOLLEYBALL(27),
    FOOTBALL(28),
    SOFTBALL(29),
    CHEERLEADING(30),
    BASEBALL(31),
    TENNIS(33),
    BADMINTON(34),
    TABLE_TENNIS(35),
    RACQUET_BALL(36),
    SQUASH(37),
    COMBAT_SPORT(38),
    BOXING(39),
    FLOORBALL(40),
    SCUBA_DIVING(51),
    FREE_DIVING(52),
    ADVENTURE_RACING(61),
    BOWLING(62),
    CRICKET(63),
    CROSSTRAINER(64),
    DANCING(65),
    GOLF(66),
    GYMNASTICS(67),
    HANDBALL(68),
    HORSEBACK_RIDING(69),
    ICE_SKATING(70),
    INDOOR_ROWING(71),
    CANOEING(72),
    MOTORSPORTS(73),
    MOUNTAINEERING(74),
    ORIENTEERING(75),
    RUGBY(76),
    SKI_TOURING(78),
    STRETCHING(79),
    TELEMARK_SKIING(80),
    TRACK_AND_FIELD(81),
    TRAIL_RUNNING(82),
    OPEN_WATER_SWIMMING(83),
    NORDIC_WALKING(84),
    SNOW_SHOEING(85),
    SURFING(86),
    KETTLEBELL(87),
    ROLLER_SKIING(88),
    STANDUP_PADDLING(89),
    CROSS_FIT(90),
    KITING(91),
    PARAGLIDING(92),
    TREADMILL(93),
    FRISBEE(94);

    private Integer id;

    public Integer getId() {
        return this.id;
    }


    private SuuntoSport(Integer id) {
        this.id = id;
    }
}
