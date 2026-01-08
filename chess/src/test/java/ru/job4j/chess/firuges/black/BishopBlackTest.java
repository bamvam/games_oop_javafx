package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure; // Добавьте этот импорт
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.position(), is(Cell.C1));
    }

    @Test
    public void testCopy() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Figure copy = bishop.copy(Cell.G5);
        assertThat(copy.position(), is(Cell.G5));
    }

    @Test
    public void testWayFromC1ToG5() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expected));
    }

    @Test
    public void testWayFromA1ToH8() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] way = bishop.way(Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(way, is(expected));
    }

    @Test
    public void testWayFromH1ToA8() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.H1);
        Cell[] way = bishop.way(Cell.A8);
        Cell[] expected = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        assertThat(way, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenNotDiagonal() throws ImpossibleMoveException {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        bishop.way(Cell.G6); // Не диагональ
    }

    @Test
    public void testIsDiagonalTrue() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertTrue(bishop.isDiagonal(Cell.C1, Cell.G5));
        assertTrue(bishop.isDiagonal(Cell.A1, Cell.H8));
        assertTrue(bishop.isDiagonal(Cell.H1, Cell.A8));
        assertTrue(bishop.isDiagonal(Cell.A8, Cell.H1));
    }

    @Test
    public void testIsDiagonalFalse() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertFalse(bishop.isDiagonal(Cell.C1, Cell.G6));
        assertFalse(bishop.isDiagonal(Cell.A1, Cell.A8));
        assertFalse(bishop.isDiagonal(Cell.H1, Cell.H8));
    }
}