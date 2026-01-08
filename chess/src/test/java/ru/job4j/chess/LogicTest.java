package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import static org.junit.Assert.*;

public class LogicTest {


    @Test(expected = OccupiedCellException.class)
    public void whenMoveThroughOccupiedCellThenException() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.E3)); // Клетка на пути

        logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveFromEmptyCellThenException() throws Exception {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveNotDiagonalThenException() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C5);
    }

    @Test
    public void whenCleanThenAllRemoved() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));

        assertEquals(2, logic.getFiguresCount());
        logic.clean();
        assertEquals(0, logic.getFiguresCount());
    }
}
