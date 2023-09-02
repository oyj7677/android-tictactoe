package camp.nextstep.edu.tictactoe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tictectoe_domain.Cell
import com.example.tictectoe_domain.Game
import com.example.tictectoe_domain.TictectoeBoard
import com.example.tictectoe_domain.TictectoeRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TictactoeViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TictactoeViewModel

    @Before
    fun setTest() {
        viewModel = TictactoeViewModel(Game())
    }

    @Test
    fun `처음 보드를 클릭하면 해당 위치의 Board에 첫번째 플레이어가 등록됩니다`() {
        // given :

        // when : 보드를 클릭한다.
        viewModel.clickBoard(1)

        // then : 보드의 해당 위치에 플레이어가 등록된다.
        assertThat(viewModel.board).isEqualTo(Cell.PLAYER1)
    }

    @Test
    fun `보드를 두번째 클릭하면 해당 위치의 Board에 두번째 플레이어가 등록됩니다`() {
        // given :

        // when : 보드를 두곳 클릭한다.
        viewModel.clickBoard(1)
        viewModel.clickBoard(2)

        // then : 보드의 2번 셀에 PLAYER2가 등록된다.
        assertThat(viewModel.board.value!![2]).isEqualTo(Cell.PLAYER2)
    }
}
