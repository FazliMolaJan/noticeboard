package net.furkanakdemir.noticeboardsample.util

import net.furkanakdemir.noticeboard.ChangeType.ADDED
import net.furkanakdemir.noticeboard.ChangeType.CHANGED
import net.furkanakdemir.noticeboard.ChangeType.DEPRECATED
import net.furkanakdemir.noticeboard.ChangeType.FIXED
import net.furkanakdemir.noticeboard.ChangeType.REMOVED
import net.furkanakdemir.noticeboard.ChangeType.SECURITY
import net.furkanakdemir.noticeboard.data.model.Release
import net.furkanakdemir.noticeboard.data.model.Release.Change
import net.furkanakdemir.noticeboard.data.model.UnRelease

object DataGenerator {

    fun createChanges(): List<Release> = listOf(
        Release(
            "30 Sep 2019", "1.0.0",
            listOf(
                Change("New Login Page", ADDED),
                Change("Toolbar in Checkout", CHANGED),
                Change("Old theme will be removed", DEPRECATED),
                Change("Tutorial page is removed", REMOVED),
                Change("Crash in Payment", FIXED),
                Change("HTTPS only requests", SECURITY)
            )
        )
    )

    fun createWithUnreleasedChanges(): List<Release> = listOf(
        Release(
            "30 Sep 2019", "1.0.0",
            listOf(
                Change("New Login Page", ADDED),
                Change("Toolbar in Checkout", CHANGED),
                Change("Old theme will be removed", DEPRECATED),
                Change("Tutorial page is removed", REMOVED),
                Change("Crash in Payment", FIXED),
                Change("HTTPS only requests", SECURITY)
            )
        ),
        UnRelease(
            "Upcoming",
            listOf(
                Change("Dark Theme"),
                Change("Support Android 10"),
                Change("Support tablets and watches")

            )
        ),
        Release(
            "30 Sep 2019", "1.0.0",
            listOf(
                Change("New Login Page", ADDED),
                Change("Toolbar in Checkout", CHANGED),
                Change("Old theme will be removed", DEPRECATED),
                Change("Tutorial page is removed", REMOVED),
                Change("Crash in Payment", FIXED),
                Change("HTTPS only requests", SECURITY)
            )
        )
    )
}
