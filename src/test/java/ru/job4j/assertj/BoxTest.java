package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisContainCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).contains("Cube");
    }

    @Test
    void isVertexEightEdgeTenAreaSixHundred() {
        Box box = new Box(8, 10);
        Double name = box.getArea();
        assertThat(name).isEqualTo(600);
    }

    @Test
    void isVertexFourEdgeTenArea173and2D() {
        Box box = new Box(4, 10);
        Double name = box.getArea();
        assertThat(name).isEqualTo(173.2d, withPrecision(0.1d));
    }

    @Test
    void getNumberOfVerticesNegative() {
        Box box = new Box(4, -1);
        int name = box.getNumberOfVertices();
        assertThat(name).isNegative();
    }

    @Test
    void isThisExist() {
        Box box = new Box(8, 3);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void isThisNotExist() {
        Box box = new Box(2, 0);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void getNumberOfVertices() {
        Box box = new Box(4, 4);
        int name = box.getNumberOfVertices();
        assertThat(name).isEqualTo(4);
    }
}