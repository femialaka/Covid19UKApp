package com.kiniun.covid.uk.app.utils

import com.kiniun.covid.uk.app.data.source.local.CovidRecordEntity
import com.kiniun.covid.uk.app.models.CovidData
import com.kiniun.covid.uk.app.models.CovidRecord
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CovidTestDataUtil {

    companion object {
        val sdf = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
        val length = covidRecordDataGenerator().size

        fun covidDataGenerator() = CovidData(covidRecordDataGenerator(), 30, length)

        fun covidRecordDataGenerator(): ArrayList<CovidRecord> {
            return arrayListOf<CovidRecord>(
                CovidRecord(
                    date = sdf.parse("Tue Aug 31 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 0,
                    newCases = 32181,
                    newDeaths = 50
                ),
                CovidRecord(
                    date = sdf.parse("Mon Aug 30 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 0,
                    newCases = 26476,
                    newDeaths = 48
                ),
                CovidRecord(
                    date = sdf.parse("Sun Aug 29 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 0,
                    newCases = 33196,
                    newDeaths = 61
                ),
                CovidRecord(
                    date = sdf.parse("Sat Aug 28 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 0,
                    newCases = 32406,
                    newDeaths = 133
                ),
                CovidRecord(
                    date = sdf.parse("Fri Aug 27 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 0,
                    newCases = 38046,
                    newDeaths = 100
                ),
                CovidRecord(
                    date = sdf.parse("Thu Aug 26 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 0,
                    newCases = 38281,
                    newDeaths = 140
                ),
                CovidRecord(
                    date = sdf.parse("Wed Aug 25 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 0,
                    newCases = 35847,
                    newDeaths = 149
                ),
                CovidRecord(
                    date = sdf.parse("Tue Aug 24 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 969,
                    newCases = 30838,
                    newDeaths = 174
                ),
                CovidRecord(
                    date = sdf.parse("Mon Aug 23 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 949,
                    newCases = 31914,
                    newDeaths = 40
                ),
                CovidRecord(
                    date = sdf.parse("Sun Aug 22 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 820,
                    newCases = 32253,
                    newDeaths = 49
                ),
                CovidRecord(
                    date = sdf.parse("Sat Aug 21 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 862,
                    newCases = 32058,
                    newDeaths = 104
                ),
                CovidRecord(
                    date = sdf.parse("Fri Aug 20 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 861,
                    newCases = 37314,
                    newDeaths = 114
                ),
                CovidRecord(
                    date = sdf.parse("Thu Aug 19 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 936,
                    newCases = 36572,
                    newDeaths = 113
                ),
                CovidRecord(
                    date = sdf.parse("Wed Aug 18 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 897,
                    newCases = 33904,
                    newDeaths = 111
                ),
                CovidRecord(
                    date = sdf.parse("Tue Aug 17 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 956,
                    newCases = 26852,
                    newDeaths = 170
                ),
                CovidRecord(
                    date = sdf.parse("Mon Aug 16 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 866,
                    newCases = 28438,
                    newDeaths = 26
                ),
                CovidRecord(
                    date = sdf.parse("Sun Aug 15 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 806,
                    newCases = 26750,
                    newDeaths = 61
                ),
                CovidRecord(
                    date = sdf.parse("Sat Aug 14 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 784,
                    newCases = 29520,
                    newDeaths = 93
                ),
                CovidRecord(
                    date = sdf.parse("Fri Aug 13 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 786,
                    newCases = 32700,
                    newDeaths = 100
                ),
                CovidRecord(
                    date = sdf.parse("Thu Aug 12 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 857,
                    newCases = 33074,
                    newDeaths = 94
                ),
                CovidRecord(
                    date = sdf.parse("Wed Aug 11 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 842,
                    newCases = 29612,
                    newDeaths = 104
                ),
                CovidRecord(
                    date = sdf.parse("Tue Aug 10 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 889,
                    newCases = 23510,
                    newDeaths = 146
                ),
                CovidRecord(
                    date = sdf.parse("Mon Aug 09 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 754,
                    newCases = 25161,
                    newDeaths = 37
                ),
                CovidRecord(
                    date = sdf.parse("Sun Aug 08 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 739,
                    newCases = 27429,
                    newDeaths = 39
                ),
                CovidRecord(
                    date = sdf.parse("Sat Aug 07 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 722,
                    newCases = 28612,
                    newDeaths = 103
                ),
                CovidRecord(
                    date = sdf.parse("Fri Aug 06 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 773,
                    newCases = 31808,
                    newDeaths = 92
                ),
                CovidRecord(
                    date = sdf.parse("Thu Aug 05 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 801,
                    newCases = 30215,
                    newDeaths = 86
                ),
                CovidRecord(
                    date = sdf.parse("Wed Aug 04 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 833,
                    newCases = 29312,
                    newDeaths = 119
                ),
                CovidRecord(
                    date = sdf.parse("Tue Aug 03 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 760,
                    newCases = 21691,
                    newDeaths = 138
                ),
                CovidRecord(
                    date = sdf.parse("Mon Aug 02 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 784,
                    newCases = 21952,
                    newDeaths = 24
                ),
                CovidRecord(
                    date = sdf.parse("Sun Aug 01 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 739,
                    newCases = 24470,
                    newDeaths = 65
                ),
                CovidRecord(
                    date = sdf.parse("Sat Jul 31 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 674,
                    newCases = 26144,
                    newDeaths = 71
                ),
                CovidRecord(
                    date = sdf.parse("Fri Jul 30 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 742,
                    newCases = 29622,
                    newDeaths = 68
                ),
                CovidRecord(
                    date = sdf.parse("Thu Jul 29 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 833,
                    newCases = 31117,
                    newDeaths = 85
                ),
                CovidRecord(
                    date = sdf.parse("Wed Jul 28 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 849,
                    newCases = 27734,
                    newDeaths = 91
                ),
                CovidRecord(
                    date = sdf.parse("Tue Jul 27 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 915,
                    newCases = 23511,
                    newDeaths = 131
                ),
                CovidRecord(
                    date = sdf.parse("Mon Jul 26 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 934,
                    newCases = 24950,
                    newDeaths = 14
                ),
                CovidRecord(
                    date = sdf.parse("Sun Jul 25 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 935,
                    newCases = 29173,
                    newDeaths = 28
                ),
                CovidRecord(
                    date = sdf.parse("Sat Jul 24 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 825,
                    newCases = 31795,
                    newDeaths = 86
                ),
                CovidRecord(
                    date = sdf.parse("Fri Jul 23 00:00:00 GMT+01:00 2021"),
                    newAdmissions = 861,
                    newCases = 36389,
                    newDeaths = 64
                )
            )
        }

        fun covidRecordEntityDataGenerator(): ArrayList<CovidRecordEntity> {
            return arrayListOf<CovidRecordEntity>(
                CovidRecordEntity(1, date = sdf.parse("Tue Aug 31 00:00:00 GMT+01:00 2021"), newAdmissions=0, newCases=32181, newDeaths=50),
                CovidRecordEntity(2, date = sdf.parse("Mon Aug 30 00:00:00 GMT+01:00 2021"), newAdmissions=0, newCases=26476, newDeaths=48),
                CovidRecordEntity(3, date = sdf.parse("Sun Aug 29 00:00:00 GMT+01:00 2021"), newAdmissions=0, newCases=33196, newDeaths=61),
                CovidRecordEntity(4, date = sdf.parse("Sat Aug 28 00:00:00 GMT+01:00 2021"), newAdmissions=0, newCases=32406, newDeaths=133),
                CovidRecordEntity(5, date = sdf.parse("Fri Aug 27 00:00:00 GMT+01:00 2021"), newAdmissions=0, newCases=38046, newDeaths=100),
                CovidRecordEntity(6, date = sdf.parse("Thu Aug 26 00:00:00 GMT+01:00 2021"), newAdmissions=0, newCases=38281, newDeaths=140),
                CovidRecordEntity(7, date = sdf.parse("Wed Aug 25 00:00:00 GMT+01:00 2021"), newAdmissions=0, newCases=35847, newDeaths=149),
                CovidRecordEntity(8, date = sdf.parse("Tue Aug 24 00:00:00 GMT+01:00 2021"), newAdmissions=969, newCases=30838, newDeaths=174),
                CovidRecordEntity(9, date = sdf.parse("Mon Aug 23 00:00:00 GMT+01:00 2021"), newAdmissions=949, newCases=31914, newDeaths=40),
                CovidRecordEntity(10, date = sdf.parse("Sun Aug 22 00:00:00 GMT+01:00 2021"), newAdmissions=820, newCases=32253, newDeaths=49),
                CovidRecordEntity(11, date = sdf.parse("Sat Aug 21 00:00:00 GMT+01:00 2021"), newAdmissions=862, newCases=32058, newDeaths=104),
                CovidRecordEntity(12, date = sdf.parse("Fri Aug 20 00:00:00 GMT+01:00 2021"), newAdmissions=861, newCases=37314, newDeaths=114),
                CovidRecordEntity(13, date = sdf.parse("Thu Aug 19 00:00:00 GMT+01:00 2021"), newAdmissions=936, newCases=36572, newDeaths=113),
                CovidRecordEntity(14, date = sdf.parse("Wed Aug 18 00:00:00 GMT+01:00 2021"), newAdmissions=897, newCases=33904, newDeaths=111),
                CovidRecordEntity(15, date = sdf.parse("Tue Aug 17 00:00:00 GMT+01:00 2021"), newAdmissions=956, newCases=26852, newDeaths=170),
                CovidRecordEntity(16, date = sdf.parse("Mon Aug 16 00:00:00 GMT+01:00 2021"), newAdmissions=866, newCases=28438, newDeaths=26),
                CovidRecordEntity(17, date = sdf.parse("Sun Aug 15 00:00:00 GMT+01:00 2021"), newAdmissions=806, newCases=26750, newDeaths=61),
                CovidRecordEntity(18, date = sdf.parse("Sat Aug 14 00:00:00 GMT+01:00 2021"), newAdmissions=784, newCases=29520, newDeaths=93),
                CovidRecordEntity(19, date = sdf.parse("Fri Aug 13 00:00:00 GMT+01:00 2021"), newAdmissions=786, newCases=32700, newDeaths=100),
                CovidRecordEntity(20, date = sdf.parse("Thu Aug 12 00:00:00 GMT+01:00 2021"), newAdmissions=857, newCases=33074, newDeaths=94),
                CovidRecordEntity(21, date = sdf.parse("Wed Aug 11 00:00:00 GMT+01:00 2021"), newAdmissions=842, newCases=29612, newDeaths=104),
                CovidRecordEntity(22, date = sdf.parse("Tue Aug 10 00:00:00 GMT+01:00 2021"), newAdmissions=889, newCases=23510, newDeaths=146),
                CovidRecordEntity(23, date = sdf.parse("Mon Aug 09 00:00:00 GMT+01:00 2021"), newAdmissions=754, newCases=25161, newDeaths=37),
                CovidRecordEntity(24, date = sdf.parse("Sun Aug 08 00:00:00 GMT+01:00 2021"), newAdmissions=739, newCases=27429, newDeaths=39),
                CovidRecordEntity(25, date = sdf.parse("Sat Aug 07 00:00:00 GMT+01:00 2021"), newAdmissions=722, newCases=28612, newDeaths=103),
                CovidRecordEntity(26, date = sdf.parse("Fri Aug 06 00:00:00 GMT+01:00 2021"), newAdmissions=773, newCases=31808, newDeaths=92),
                CovidRecordEntity(27, date = sdf.parse("Thu Aug 05 00:00:00 GMT+01:00 2021"), newAdmissions=801, newCases=30215, newDeaths=86),
                CovidRecordEntity(28, date = sdf.parse("Wed Aug 04 00:00:00 GMT+01:00 2021"), newAdmissions=833, newCases=29312, newDeaths=119),
                CovidRecordEntity(29, date = sdf.parse("Tue Aug 03 00:00:00 GMT+01:00 2021"), newAdmissions=760, newCases=21691, newDeaths=138),
                CovidRecordEntity(30, date = sdf.parse("Mon Aug 02 00:00:00 GMT+01:00 2021"), newAdmissions=784, newCases=21952, newDeaths=24),
                CovidRecordEntity(31, date = sdf.parse("Sun Aug 01 00:00:00 GMT+01:00 2021"), newAdmissions=739, newCases=24470, newDeaths=65),
                CovidRecordEntity(32, date = sdf.parse("Sat Jul 31 00:00:00 GMT+01:00 2021"), newAdmissions=674, newCases=26144, newDeaths=71),
                CovidRecordEntity(33, date = sdf.parse("Fri Jul 30 00:00:00 GMT+01:00 2021"), newAdmissions=742, newCases=29622, newDeaths=68),
                CovidRecordEntity(34, date = sdf.parse("Thu Jul 29 00:00:00 GMT+01:00 2021"), newAdmissions=833, newCases=31117, newDeaths=85),
                CovidRecordEntity(35, date = sdf.parse("Wed Jul 28 00:00:00 GMT+01:00 2021"), newAdmissions=849, newCases=27734, newDeaths=91),
                CovidRecordEntity(36, date = sdf.parse("Tue Jul 27 00:00:00 GMT+01:00 2021"), newAdmissions=915, newCases=23511, newDeaths=131),
                CovidRecordEntity(37, date = sdf.parse("Mon Jul 26 00:00:00 GMT+01:00 2021"), newAdmissions=934, newCases=24950, newDeaths=14),
                CovidRecordEntity(38, date = sdf.parse("Sun Jul 25 00:00:00 GMT+01:00 2021"), newAdmissions=935, newCases=29173, newDeaths=28),
                CovidRecordEntity(39, date = sdf.parse("Sat Jul 24 00:00:00 GMT+01:00 2021"), newAdmissions=825, newCases=31795, newDeaths=86),
                CovidRecordEntity(40, date = sdf.parse("Fri Jul 23 00:00:00 GMT+01:00 2021"), newAdmissions=861, newCases=36389, newDeaths=64))

        }

        val covidApiJsonData = """{
    "length": 613,
    "maxPageLimit": 2500,
    "totalRecords": 1746,
    "data": [
        {
            "date": "2021-10-04",
            "newAdmissions": null,
            "newCases": 35077,
            "newDeaths": 33
        },
        {
            "date": "2021-10-03",
            "newAdmissions": null,
            "newCases": 30439,
            "newDeaths": 43
        },
        {
            "date": "2021-10-02",
            "newAdmissions": null,
            "newCases": 30301,
            "newDeaths": 121
        },
        {
            "date": "2021-10-01",
            "newAdmissions": null,
            "newCases": 35577,
            "newDeaths": 127
        },
        {
            "date": "2021-09-30",
            "newAdmissions": null,
            "newCases": 36480,
            "newDeaths": 137
        },
        {
            "date": "2021-09-29",
            "newAdmissions": null,
            "newCases": 36722,
            "newDeaths": 150
        },
        {
            "date": "2021-09-28",
            "newAdmissions": 754,
            "newCases": 34526,
            "newDeaths": 167
        },
        {
            "date": "2021-09-27",
            "newAdmissions": 770,
            "newCases": 37960,
            "newDeaths": 40
        },
        {
            "date": "2021-09-26",
            "newAdmissions": 659,
            "newCases": 32417,
            "newDeaths": 58
        },
        {
            "date": "2021-09-25",
            "newAdmissions": 661,
            "newCases": 32468,
            "newDeaths": 127
        },
        {
            "date": "2021-09-24",
            "newAdmissions": 723,
            "newCases": 35623,
            "newDeaths": 180
        },
        {
            "date": "2021-09-23",
            "newAdmissions": 764,
            "newCases": 36710,
            "newDeaths": 182
        },
        {
            "date": "2021-09-22",
            "newAdmissions": 742,
            "newCases": 34460,
            "newDeaths": 166
        },
        {
            "date": "2021-09-21",
            "newAdmissions": 786,
            "newCases": 31564,
            "newDeaths": 203
        },
        {
            "date": "2021-09-20",
            "newAdmissions": 804,
            "newCases": 36100,
            "newDeaths": 49
        },
        {
            "date": "2021-09-19",
            "newAdmissions": 723,
            "newCases": 29612,
            "newDeaths": 56
        },
        {
            "date": "2021-09-18",
            "newAdmissions": 757,
            "newCases": 30144,
            "newDeaths": 164
        },
        {
            "date": "2021-09-17",
            "newAdmissions": 755,
            "newCases": 32651,
            "newDeaths": 178
        },
        {
            "date": "2021-09-16",
            "newAdmissions": 884,
            "newCases": 26911,
            "newDeaths": 158
        },
        {
            "date": "2021-09-15",
            "newAdmissions": 941,
            "newCases": 30597,
            "newDeaths": 201
        },
        {
            "date": "2021-09-14",
            "newAdmissions": 943,
            "newCases": 26628,
            "newDeaths": 185
        },
        {
            "date": "2021-09-13",
            "newAdmissions": 934,
            "newCases": 30825,
            "newDeaths": 61
        }]
}"""
    }
}