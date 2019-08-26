package example.com.kotlin_android_api_tutorial

import example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC.BeatBox
import example.com.kotlin_android_api_tutorial.T23_SoundPool_MVC.Sound
import example.com.kotlin_android_api_tutorial.viewmodel.SoundViewModel

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class SoundViewModelTest {

    lateinit var beatBox: BeatBox
    lateinit var sound: Sound
    lateinit var subject: SoundViewModel


    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        sound = Sound("assertPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposeSoundNameAsTitle() {
        assertThat(subject.title, `is`(sound.name))
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()

        verify(beatBox).play(sound)
    }
}