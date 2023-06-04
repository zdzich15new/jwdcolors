package pl.edu.wszib.jwd.jwdcolors.service;

import pl.edu.wszib.jwd.jwdcolors.model.SelectedColor;

import java.util.List;

public interface SelectedColorService {
        void save(String color);
        void save(SelectedColor selectedColor);
        List<SelectedColor> getAllData();
}
