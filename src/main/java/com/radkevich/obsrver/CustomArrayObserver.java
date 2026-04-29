package com.radkevich.obsrver;

import com.radkevich.entity.CustomArrayEvent;

public interface CustomArrayObserver  {
    void update(CustomArrayEvent event);
}